package basedatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Utils.configs.Configurations;

public class BaseDatos {
    private Connection connection;


    public BaseDatos() {
        try {
            Configurations configs = Configurations.getInstance(); // Obtiene la configuración
            String url = "jdbc:mysql://" + configs.getDatabaseConfigurations().getHost() + ":" +
                         configs.getDatabaseConfigurations().getPort() + "/" +
                         configs.getDatabaseConfigurations().getDatabase();
            String user = configs.getDatabaseConfigurations().getUsername();
            String password = configs.getDatabaseConfigurations().getPassword();

            connection = DriverManager.getConnection(url, user, password); // Conecta a la base de datos
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer la configuración: " + e.getMessage());
        }	
    }

    public Connection getConnection() {
        return connection; // Devuelve la conexión
    }
}