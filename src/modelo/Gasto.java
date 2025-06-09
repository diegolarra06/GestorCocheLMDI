package modelo;

public class Gasto {
    private String matriculaCoche;
    private String tipoGasto; // gasolina, revision, ITV, aceite, otros
    private int kilometros;
    private String fecha; // String, no Date
    private double importe;
    private String descripcion;

    // Constructor
    public Gasto(String matriculaCoche, String tipoGasto, int kilometros, String fecha, double importe, String descripcion) {
        this.matriculaCoche = matriculaCoche;
        this.tipoGasto = tipoGasto;
        this.kilometros = kilometros;
        this.fecha = fecha;
        this.importe = importe;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public String getMatriculaCoche() { return matriculaCoche; }
    public String getTipoGasto() { return tipoGasto; }
    public int getKilometros() { return kilometros; }
    public String getFecha() { return fecha; }
    public double getImporte() { return importe; }
    public String getDescripcion() { return descripcion; }
}
