package dominio;

public class CuchilloObtenido {
    private String nombre;
    private double probabilidad;
    private Calidad calidad;

    public CuchilloObtenido(String nombre, double probabilidad, Calidad calidad) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
        this.calidad = calidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    @Override
    public String toString() {
        return nombre + " | Probabilidad: " + probabilidad * 100 + "% | Calidad: " + calidad;
    }
}