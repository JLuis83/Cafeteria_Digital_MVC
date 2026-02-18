package Vista;
import Modelo.Pagar;
import Modelo.Producto;
import Lógica.Cafeteria;
import Utils.InputReader;
import java.util.ArrayList;

import static Utils.InputReader.sc;

public class CafeteriaVistaCLI {

    private Cafeteria service;

    public CafeteriaVistaCLI(Cafeteria service) {

        this.service = service;
    }
        //Menú principal
    public void iniciar() {

        int opcion;

        do {

            mostrarMenuPrincipal();
            opcion = Utils.InputReader.leerEntero("Elige una opción:");

            switch (opcion) {
                case 1 ->{
                    mostrarMenu();
                    CustomCLI.titulo("\nPulsa ENTER para volver al menú principal...");
                    sc.nextLine(); // limpiar buffer
                }
                case 2 -> agregarNuevoPedido();
                case 3 -> mostrarPedidos();
                case 4 -> service.pagarTarjeta();
                case 0 -> System.out.println("Saliendo...");
                default -> CustomCLI.error("Opción inválida");
            }

        } while (opcion != 0);

        Utils.InputReader.cerrar();
    }
    //Mostrar menu principal
    private void mostrarMenuPrincipal() {

        CustomCLI.titulo("MENÚ CAFETERÍA");
        System.out.println("1-Mostrar menú");
        System.out.println("2-Añadir Pedido");
        System.out.println("3-Ver Pedidos");
        System.out.println("4-Pago con Tarjeta)");
        System.out.println("0-Salir");
    }
        //Muestra el menú del cliente
    private void mostrarMenu() {

        CustomCLI.titulo("===Productos Desordenados===");
        service.getProductosDesordenados()
                .forEach((producto, precio) ->
                        System.out.println(producto + " = " + precio + "€"));

        CustomCLI.titulo("===Productos Ordenados===");
        service.getProductosOrdenados()
                .forEach((producto, precio) ->
                        System.out.println(producto + " = " + precio + "€"));
    }
    //añade un nuevo pedido
    private void agregarNuevoPedido() {

        String nombreCliente = InputReader.leerTexto("Nombre Cliente");
        service.setNombreCliente(nombreCliente);

        ArrayList<Producto> productos = new ArrayList<>();

        while (true) {

            mostrarMenu();

            String entrada = InputReader.leerTexto("Introduce producto (o fin para acabar)");

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            Producto validado = service.buscarProductoMenu(entrada);

            if (validado != null) {
                productos.add(validado);
            } else {
                CustomCLI.error("Producto no válido");
            }
        }

        service.agregarNuevoPedido(productos);
    }

    private void mostrarPedidos() {

        CustomCLI.titulo("-------Pedidos Pendientes-------");

        service.getPedidosRealizados()
                .forEach(System.out::println);

        System.out.println("----------------------------");
    }


    private void atenderPedido() {

        String atendido = service.pedidosAtendidos();

        if (atendido != null) {
            CustomCLI.titulo("Pedido atendido: " + atendido);
        } else {
            CustomCLI.error("No hay pedidos pendientes");
        }
    }

    public String pedirNombreCliente(){

        CustomCLI.titulo("Escriba su nombre");
        return sc.nextLine().trim();


    }
}
