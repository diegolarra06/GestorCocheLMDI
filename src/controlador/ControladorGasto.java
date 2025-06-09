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

    // Obtener todos los gastos de un coche (sin filtros)
    public ResultSet obtenerGastosDeCoche(String matricula) throws SQLException {
        return gestorDatos.obtenerGastosFiltrados(matricula, null, null, null);
    }

    // Obtener gastos filtrados por año, fecha y kilometraje
    public ResultSet obtenerGastosFiltrados(String matricula, String año, String fechaDesde, String fechaHasta, Integer kmMin, Integer kmMax) throws SQLException {
        // Este método solo filtra por año y km (no por rango de fechas)
        // Si necesitas filtrar por rango de fechas, debes modificar el método en GestorDatos
        // Aquí lo adaptamos para que funcione con los parámetros básicos disponibles
        return gestorDatos.obtenerGastosFiltrados(matricula, año, kmMin, kmMax);
    }

    // Método auxiliar: transformar ResultSet a lista de objetos Gasto (simplificado)
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

    // Editar un gasto (requiere implementar método en GestorDatos)
    public boolean editarGasto(int idGasto, String tipo, int km, String fecha, double importe, String descripcion) throws SQLException {
        // Implementa en GestorDatos: "UPDATE gastos SET tipo=?, km=?, fecha=?, importe=?, descripcion=? WHERE id=?"
        // ¡Este método es solo un ejemplo! Debes implementarlo en GestorDatos.
        return false;
    }

    // Eliminar un gasto (requiere implementar método en GestorDatos)
    public boolean eliminarGasto(int idGasto) throws SQLException {
        // Implementa en GestorDatos: "DELETE FROM gastos WHERE id=?"
        // ¡Este método es solo un ejemplo! Debes implementarlo en GestorDatos.
        return false;
    }

    // Clase interna para facilitar el manejo de gastos en la vista
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
