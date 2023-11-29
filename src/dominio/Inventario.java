package dominio;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<CuchilloObtenido> cuchillos;

    public Inventario() {
        cuchillos = new ArrayList<>();
    }

    public String mostrarInventario() {
        StringBuilder resultado = new StringBuilder("Inventario:\n");
        for (CuchilloObtenido cuchillo : cuchillos) {
            resultado.append(cuchillo.getNombre()).append(" - Calidad: ").append(cuchillo.getCalidad()).append("\n");
        }
        return resultado.toString();
    }

    public void agregarCuchillo(CuchilloObtenido cuchilloObtenidoInfo) {
        cuchillos.add(cuchilloObtenidoInfo);
        System.out.println("Cuchillo agregado al inventario: " + cuchilloObtenidoInfo.getNombre() +
                " - Calidad: " + cuchilloObtenidoInfo.getCalidad());
    }
}
