package aplicacion;

import interfaz.Interfaz;
import dominio.Usuario;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de Interfaz
        Interfaz interfaz = new Interfaz();

        // Crear una instancia de Usuario
        Usuario usuario = new Usuario(interfaz);

        // Crear un Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario qué acción desea realizar
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
                    interfaz.mostrarMensaje("Inventario actual:\n" + usuario.verInventario());
                    break;
                case "3":
                    interfaz.mostrarMensaje("Saldo actual: $" + usuario.getSaldoBilletera());
                    break;
                case "4":
                    interfaz.mostrarMensaje("¡Gracias por usar la aplicación!");
                    interfaz.mostrarMensaje("Lograste obtener $" + usuario.getSaldoBilletera() + " y tienes los siguientes cuchillos en el inventario:\n" + usuario.verInventario());
                    break;
                default:
                    interfaz.mostrarMensaje("Opción no válida. Por favor, elige una opción válida.");
            }

            // Si la opción es "4. Salir", salir del bucle
            if (opcion.equals("4")) {
                break;
            }
        }

        // Cerrar el Scanner
        scanner.close();
    }
}
