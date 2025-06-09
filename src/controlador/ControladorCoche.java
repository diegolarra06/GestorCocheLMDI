package controlador;


import basedatos.GestorDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ControladorCoche {
    private final GestorDatos gestorDatos;

    public ControladorCoche(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
    }

    // Crear coche (retorna true si se crea correctamente)
    public boolean crearCoche(String matricula, String marca, String modelo, int año) throws SQLException {
        return gestorDatos.insertarCoche(matricula, marca, modelo, año);
    }

    // Editar coche (¡IMPORTANTE! Necesitarías un método en GestorDatos para actualizar)
    public boolean editarCoche(String matricula, String marca, String modelo, int año) throws SQLException {
        // Este método no está implementado en GestorDatos, pero aquí tienes el esqueleto:
        // "UPDATE coches SET marca = ?, modelo = ?, año = ? WHERE matricula = ?"
        // ¡Implementa esto en GestorDatos si lo necesitas!
        return false;
    }

    // Eliminar coche (¡IMPORTANTE! Necesitarías un método en GestorDatos para borrar)
    public boolean eliminarCoche(String matricula) throws SQLException {
        // Este método no está implementado en GestorDatos, pero aquí tienes el esqueleto:
        // "DELETE FROM coches WHERE matricula = ?"
        // ¡Implementa esto en GestorDatos si lo necesitas!
        return false;
    }

    // Añadir gasto a coche
    public boolean añadirGasto(String matricula, String tipo, int km, String fecha, double importe, String descripcion) throws SQLException {
        return gestorDatos.insertarGasto(matricula, tipo, km, fecha, importe, descripcion);
    }

    // Ver gastos de coche (con filtros)
    public ResultSet obtenerGastosFiltrados(String matricula, String año, Integer kmMin, Integer kmMax) throws SQLException {
        return gestorDatos.obtenerGastosFiltrados(matricula, año, kmMin, kmMax);
    }

    // Obtener todos los coches de un usuario (ya está en ControladorUsuario, pero lo dejamos por si lo quieres aquí)
    public List<String> obtenerCochesDeUsuario(String uuidUsuario) throws SQLException {
        return gestorDatos.obtenerCochesDeUsuario(uuidUsuario);
    }

    
   
    }

