package main;

import basedatos.BaseDatos;
import basedatos.GestorDatos;
import controlador.ControladorCoche;
import controlador.ControladorGasto;
import controlador.ControladorUsuario;
import vista.VistaConsola;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        BaseDatos db = new BaseDatos();
        GestorDatos gestor = new GestorDatos(db);
        ControladorUsuario cUsuario = new ControladorUsuario(gestor);
        ControladorCoche cCoche = new ControladorCoche(gestor);
        ControladorGasto cGasto = new ControladorGasto(gestor);
        VistaConsola vista = new VistaConsola();
        String uuid = null;
        String nombre, pass;

        // Registro de usuario
        vista.mostrarMenuPrincipal();
        int opcion = vista.pedirEntero("Opción");
        if (opcion == 1) {
            nombre = vista.pedirTexto("Nombre");
            pass = vista.pedirTexto("Contraseña");
            uuid = cUsuario.registrarUsuario(nombre, pass);
            System.out.println("Usuario registrado. Ahora haz login.");
        } else if (opcion == 3) {
            System.exit(0);
        }

        // Login del usuario recién registrado
        if (uuid == null) {
            System.out.println("Debes registrar un usuario antes de hacer login.");
            return;
        }
        nombre = vista.pedirTexto("Nombre");
        pass = vista.pedirTexto("Contraseña");
        uuid = cUsuario.login(nombre, pass);
        if (uuid == null) {
            System.out.println("Login fallido.");
            return;
        }

        // Menú de usuario (coches y gastos)
        while (true) {
            vista.mostrarMenuUsuario();
            opcion = vista.pedirEntero("Opción");
            if (opcion == 1) {
                String matricula = vista.pedirTexto("Matrícula");
                String marca = vista.pedirTexto("Marca");
                String modelo = vista.pedirTexto("Modelo");
                int año = vista.pedirEntero("Año");
                cCoche.crearCoche(matricula, marca, modelo, año);
                cUsuario.añadirPropietario(uuid, matricula);
            } else if (opcion == 2) {
                List<String> coches = cUsuario.obtenerCochesDeUsuario(uuid);
                vista.mostrarCoches(coches);
            } else if (opcion == 3) {
                String matricula = vista.pedirTexto("Matrícula");
                String uuidPropietario = vista.pedirTexto("UUID del nuevo propietario");
                cUsuario.añadirPropietario(uuidPropietario, matricula);
            } else if (opcion == 4) {
                String matricula = vista.pedirTexto("Matrícula");
                String tipo = vista.pedirTipoGasto();
                int km = vista.pedirEntero("Kilometraje");
                String fecha = vista.pedirFecha();
                double importe = vista.pedirDouble("Importe");
                String descripcion = vista.pedirTexto("Descripción (opcional)");
                cGasto.añadirGasto(matricula, tipo, km, fecha, importe, descripcion);
            } else if (opcion == 5) {
                String matricula = vista.pedirTexto("Matrícula");
                ResultSet gastos = cGasto.obtenerGastosDeCoche(matricula);
                vista.mostrarGastos(gastos);
            } else if (opcion == 6) {
                break;
            }
        }
        System.out.println("Sesión cerrada.");
    }
}

