package modelo;
public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private int año;

    // Constructor
    public Coche(String matricula, String marca, String modelo, int año) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    // Getters y setters
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAño(int año) { this.año = año; }
}
