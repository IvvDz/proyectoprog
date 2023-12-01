package aplicacion;

import interfaz.Interfaz;
import dominio.Usuario;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();

        Usuario usuario = new Usuario(interfaz);

        Scanner scanner = new Scanner(System.in);
        
        interfaz.mostrarMensaje("¡Bienvenido a la aplicación de apertura de cajas, comienzas con 100$ y cada caja cuesta 20$!");
        while (true) {
            interfaz.mostrarMensaje("¿Qué deseas hacer?");
            interfaz.mostrarMensaje("1. Abrir una caja");
            interfaz.mostrarMensaje("2. Ver el inventario");
            interfaz.mostrarMensaje("3. Ver el saldo");
            interfaz.mostrarMensaje("4. Salir");

            String opcion = scanner.nextLine().toLowerCase();

            switch (opcion) {
                case "1":
                    usuario.abrirCaja();
                    break;
                case "2":
                    interfaz.mostrarMensaje(usuario.verInventario());
                    break;
                case "3":
                    interfaz.mostrarMensaje("Saldo actual: $" + usuario.getSaldoBilletera());
                    break;
                case "4":
                    interfaz.mostrarMensaje("¡Gracias por usar la aplicación!");
                    interfaz.mostrarMensaje("Lograste obtener $" + usuario.getSaldoBilletera() + " y tienes los siguientes cuchillos:\n" + usuario.verInventario());
                    break;
                default:
                    interfaz.mostrarMensaje("Opción no válida. Por favor, elige una opción válida.");
            }

            if (opcion.equals("4")) {
                break;
            }
        }

        scanner.close();
    }
}
