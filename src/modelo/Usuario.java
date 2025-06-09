package modelo;
public class Usuario {
    private String uuid;
    private String nombre;
    private String password;

    // Constructor
    public Usuario(String uuid, String nombre, String password) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.password = password;
    }

    // Getters y setters
    public String getUuid() { return uuid; }
    public String getNombre() { return nombre; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
