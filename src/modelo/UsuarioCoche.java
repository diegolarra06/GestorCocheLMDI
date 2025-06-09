package modelo;

public class UsuarioCoche {
    private String uuidUsuario;
    private String matriculaCoche;

    // Constructor
    public UsuarioCoche(String uuidUsuario, String matriculaCoche) {
        this.uuidUsuario = uuidUsuario;
        this.matriculaCoche = matriculaCoche;
    }

    // Getters
    public String getUuidUsuario() { return uuidUsuario; }
    public String getMatriculaCoche() { return matriculaCoche; }
}
