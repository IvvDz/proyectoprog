package dominio;

public class Cuchillo {
    private String nombre;
    private Calidad calidad;

    public Cuchillo(String nombre, Calidad calidad) {
        this.nombre = nombre;
        this.calidad = calidad;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + calidad + ")";
    }
}
