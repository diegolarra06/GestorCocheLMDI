package controlador;

import basedatos.GestorDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorGasto {
    private final GestorDatos gestorDatos;

    public ControladorGasto(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
    }

    // Añadir un nuevo gasto
    public boolean añadirGasto(String matricula, String tipo, int km, String fecha, double importe, String descripcion) throws SQLException {
        return gestorDatos.insertarGasto(matricula, tipo, km, fecha, importe, descripcion);
    }

    // Obtener todos los gastos de un coche 
    public ResultSet obtenerGastosDeCoche(String matricula) throws SQLException {
        return gestorDatos.obtenerGastosFiltrados(matricula, null, null, null);
    }

    // Obtener gastos filtrados por año, fecha y kilometraje
    public ResultSet obtenerGastosFiltrados(String matricula, String año, String fechaDesde, String fechaHasta, Integer kmMin, Integer kmMax) throws SQLException {
        return gestorDatos.obtenerGastosFiltrados(matricula, año, kmMin, kmMax);
    }

    
    public List<GastoSimplificado> listarGastos(ResultSet rs) throws SQLException {
        List<GastoSimplificado> gastos = new ArrayList<>();
        while (rs.next()) {
            gastos.add(new GastoSimplificado(
                rs.getString("fecha"),
                rs.getString("tipo"),
                rs.getInt("km"),
                rs.getDouble("importe"),
                rs.getString("descripcion")
            ));
        }
        return gastos;
    }

    // Editar un gasto 
    public boolean editarGasto(int idGasto, String tipo, int km, String fecha, double importe, String descripcion) throws SQLException {
        return false;
    }

    // Eliminar un gasto
    public boolean eliminarGasto(int idGasto) throws SQLException { 
        return false;
    }

    
    public static class GastoSimplificado {
        public final String fecha;
        public final String tipo;
        public final int km;
        public final double importe;
        public final String descripcion;

        public GastoSimplificado(String fecha, String tipo, int km, double importe, String descripcion) {
            this.fecha = fecha;
            this.tipo = tipo;
            this.km = km;
            this.importe = importe;
            this.descripcion = descripcion;
        }
    }
}
