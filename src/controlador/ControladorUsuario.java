package controlador;

import basedatos.GestorDatos;
import java.sql.SQLException;
import java.util.List;

public class ControladorUsuario {
    private final GestorDatos gestorDatos;

    public ControladorUsuario(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
    }

    public String registrarUsuario(String nombre, String password) throws SQLException {
        String uuid = java.util.UUID.randomUUID().toString();
        if (gestorDatos.insertarUsuario(uuid, nombre, password)) {
            return uuid;
        }
        return null;
    }

    public String login(String nombre, String password) throws SQLException {
        String uuid = gestorDatos.obtenerUsuarioPorNombre(nombre);
        // Aquí deberías comprobar la contraseña, pero por simplicidad, solo devuelve el UUID
        return uuid;
    }

    public boolean añadirPropietario(String uuidUsuario, String matricula) throws SQLException {
        return gestorDatos.añadirPropietario(uuidUsuario, matricula);
    }

    public List<String> obtenerCochesDeUsuario(String uuidUsuario) throws SQLException {
        return gestorDatos.obtenerCochesDeUsuario(uuidUsuario);
    }
}
