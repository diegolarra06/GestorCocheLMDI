package basedatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private final BaseDatos baseDatos;

    public GestorDatos(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public boolean insertarUsuario(String uuid, String nombre, String password) throws SQLException {
        String sql = "INSERT INTO usuarios (uuid, nombre, password) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, uuid);
            pstmt.setString(2, nombre);
            pstmt.setString(3, password);
            return pstmt.executeUpdate() > 0;
        }
    }

    public String obtenerUsuarioPorNombre(String nombre) throws SQLException {
        String sql = "SELECT uuid FROM usuarios WHERE nombre = ?";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getString("uuid") : null;
        }
    }

    public boolean insertarCoche(String matricula, String marca, String modelo, int año) throws SQLException {
        String sql = "INSERT INTO coches (matricula, marca, modelo, año) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            pstmt.setString(2, marca);
            pstmt.setString(3, modelo);
            pstmt.setInt(4, año);
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean existeCoche(String matricula) throws SQLException {
        String sql = "SELECT matricula FROM coches WHERE matricula = ?";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            return pstmt.executeQuery().next();
        }
    }

    public boolean insertarGasto(String matricula, String tipo, int km, String fecha, double importe, String descripcion) throws SQLException {
        String sql = "INSERT INTO gastos (matricula, tipo, km, fecha, importe, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            pstmt.setString(2, tipo);
            pstmt.setInt(3, km);
            pstmt.setString(4, fecha);
            pstmt.setDouble(5, importe);
            pstmt.setString(6, descripcion);
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean añadirPropietario(String uuidUsuario, String matricula) throws SQLException {
        String sql = "INSERT INTO usuarios_coches (usuario_uuid, matricula) VALUES (?, ?)";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, uuidUsuario);
            pstmt.setString(2, matricula);
            return pstmt.executeUpdate() > 0;
        }
    }

    public List<String> obtenerCochesDeUsuario(String uuidUsuario) throws SQLException {
        List<String> coches = new ArrayList<>();
        String sql = "SELECT matricula FROM usuarios_coches WHERE usuario_uuid = ?";
        try (PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, uuidUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                coches.add(rs.getString("matricula"));
            }
        }
        return coches;
    }

    public ResultSet obtenerGastosFiltrados(String matricula, String año, Integer kmMin, Integer kmMax) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM gastos WHERE matricula = ?");
        if (año != null) sql.append(" AND fecha LIKE ?");
        if (kmMin != null) sql.append(" AND km >= ?");
        if (kmMax != null) sql.append(" AND km <= ?");
        PreparedStatement pstmt = baseDatos.getConnection().prepareStatement(sql.toString());
        pstmt.setString(1, matricula);
        int paramIndex = 2;
        if (año != null) pstmt.setString(paramIndex++, año + "%");
        if (kmMin != null) pstmt.setInt(paramIndex++, kmMin);
        if (kmMax != null) pstmt.setInt(paramIndex++, kmMax);
        return pstmt.executeQuery();
    }
}
