package interfaz;

import java.util.Scanner;

public class Interfaz {
    private Scanner scanner;

    public Interfaz() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerEntrada() {
        return scanner.nextLine();
    }
}
