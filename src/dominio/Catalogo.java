package dominio;

import java.util.ArrayList;
import java.util.Random;

public class Catalogo {
    private ArrayList<Cuchillo> cuchillos;
    private Random random;

    public Catalogo() {
        cuchillos = new ArrayList<>();
        random = new Random();
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        agregarCuchillo("Cuchillo roto", Calidad.COMUN, 50);
        agregarCuchillo("Cuchillo de Acero", Calidad.RARO, 30);
        agregarCuchillo("Karambit Dorado", Calidad.EPICO, 10);
        agregarCuchillo("M9 Bayoneta", Calidad.MITICO, 3);
        agregarCuchillo("Cuchillo Mariposa", Calidad.MITICO, 3);
        agregarCuchillo("God's Sword", Calidad.LEGENDARIO, 1);
        agregarCuchillo("Machete de Diamante", Calidad.LEGENDARIO, 2);
        agregarCuchillo("Cuchillo de Platano Especial", Calidad.ESPECIAL, 1);
    }

    private void agregarCuchillo(String nombre, Calidad calidad, int probabilidad) {
        Cuchillo cuchillo = new Cuchillo(nombre, calidad);
        for (int i = 0; i < probabilidad; i++) {
            cuchillos.add(cuchillo);
        }
    }

    public Cuchillo obtenerCuchilloAleatorio() {
        return cuchillos.get(random.nextInt(cuchillos.size()));
    }

    public double obtenerProbabilidad(Cuchillo cuchillo) {
        int cantidadTotal = cuchillos.size();
        int cantidadCuchillo = (int) cuchillos.stream().filter(c -> c.equals(cuchillo)).count();
        return ((double) cantidadCuchillo / cantidadTotal) * 100.0;
    }

    public int obtenerPrecioVenta(CuchilloObtenido cuchillo) {
        switch (cuchillo.getCalidad()) {
            case COMUN:
                return 5;
            case RARO:
                return 10;
            case EPICO:
                return 20;
            case MITICO:
                return 100;
            case LEGENDARIO:
                return 1000;
            case ESPECIAL:
                return 6666;
            default:
                return 0; 
        }
    }
}
