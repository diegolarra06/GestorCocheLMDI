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

    // Crear coche 
    public boolean crearCoche(String matricula, String marca, String modelo, int año) throws SQLException {
        return gestorDatos.insertarCoche(matricula, marca, modelo, año);
    }

    // Editar coche 
    public boolean editarCoche(String matricula, String marca, String modelo, int año) throws SQLException {
        return false;
    }

    // Eliminar coche 
    public boolean eliminarCoche(String matricula) throws SQLException {
        
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

    // Obtener todos los coches de un usuario 
    public List<String> obtenerCochesDeUsuario(String uuidUsuario) throws SQLException {
        return gestorDatos.obtenerCochesDeUsuario(uuidUsuario);
    }

    
   
    }

