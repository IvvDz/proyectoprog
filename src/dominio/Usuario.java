package dominio;

import interfaz.Interfaz;

public class Usuario {
    private Interfaz interfaz;
    private Inventario inventario;
    private Catalogo catalogo;
    private Billetera billetera;

    public Usuario(Interfaz interfaz) {
        this.interfaz = interfaz;
        this.inventario = new Inventario();
        this.catalogo = new Catalogo();
        this.billetera = new Billetera(100);
    }

    public void iniciarAplicacion() {
        interfaz.mostrarMensaje("¡Bienvenido al programa de apertura de cajas!");
        while (true) {
            interfaz.mostrarMensaje("¿Qué deseas hacer?");
            interfaz.mostrarMensaje("1. Abrir una caja");
            interfaz.mostrarMensaje("2. Ver el inventario");
            interfaz.mostrarMensaje("3. Ver el saldo");
            interfaz.mostrarMensaje("4. Salir");

            String opcion = interfaz.leerEntrada().toLowerCase();

            switch (opcion) {
                case "1":
                    abrirCaja();
                    break;
                case "2":
                    mostrarInventario();
                    break;
                case "3":
                    mostrarSaldo();
                    break;
                case "4":
                    interfaz.mostrarMensaje("¡Gracias por usar la aplicación!");
                    mostrarResultadoFinal();
                    return; // Salir del bucle si el usuario elige salir
                default:
                    interfaz.mostrarMensaje("Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }

    private void mostrarInventario() {
        interfaz.mostrarMensaje("Inventario actual:\n" + inventario.mostrarInventario());
    }

    private void mostrarSaldo() {
        interfaz.mostrarMensaje("Saldo actual: $" + billetera.getSaldo());
    }

    public void abrirCaja() {
        // Verificar si hay suficiente saldo para abrir la caja
        if (billetera.getSaldo() >= 20) {
            // Restar $20 del saldo por abrir la caja
            billetera.restarSaldo(20);
    
            // Obtener cuchillo aleatorio
            Cuchillo cuchilloObtenido = catalogo.obtenerCuchilloAleatorio();
            interfaz.mostrarMensaje("¡Has obtenido un cuchillo!");
   
            // Crear instancia de CuchilloObtenido y agregar al inventario
            CuchilloObtenido cuchilloObtenidoInfo = new CuchilloObtenido(
                cuchilloObtenido.getNombre(),
                catalogo.obtenerProbabilidad(cuchilloObtenido),
                cuchilloObtenido.getCalidad()
            );
            // Mostrar información del cuchillo obtenido
            mostrarInformacionCuchillo(cuchilloObtenidoInfo);
    
            // Agregar cuchillo al inventario
            inventario.agregarCuchillo(cuchilloObtenidoInfo);
    
            // Preguntar al usuario si desea vender el cuchillo
            interfaz.mostrarMensaje("¿Deseas vender este cuchillo? (si/no): ");
            String respuesta = interfaz.leerEntrada().toLowerCase();
    
            if (respuesta.equals("sí") || respuesta.equals("si")) {
                venderCuchillo(cuchilloObtenidoInfo);
            }
        } else {
            interfaz.mostrarMensaje("No tienes suficiente dinero para abrir una caja.");
        }
    }
    
    private void mostrarInformacionCuchillo(CuchilloObtenido cuchillo) {
        interfaz.mostrarMensaje("Cuchillo obtenido: " + cuchillo.getNombre());
        interfaz.mostrarMensaje("Calidad: " + cuchillo.getCalidad());
        interfaz.mostrarMensaje("Probabilidad de obtenerlo: " + cuchillo.getProbabilidad() + "%");
    }

    private void venderCuchillo(CuchilloObtenido cuchilloObtenido) {
        int precio = catalogo.obtenerPrecioVenta(cuchilloObtenido);
        billetera.sumarSaldo(precio);
        interfaz.mostrarMensaje("Has vendido el cuchillo por $" + precio + ". Saldo actual: $" + billetera.getSaldo());
    }
    

    private void mostrarResultadoFinal() {
        interfaz.mostrarMensaje("Lograste obtener $" + billetera.getSaldo() + " y tienes los siguientes cuchillos en el inventario:");
        interfaz.mostrarMensaje(verInventario());
    }

    public String verInventario() {
        return inventario.mostrarInventario();
    }

    public int getSaldoBilletera() {
        return billetera.getSaldo();
    }
}