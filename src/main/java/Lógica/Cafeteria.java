package Lógica;
import Modelo.Pagar;
import Modelo.Producto;
import Vista.CustomCLI;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

import static Utils.InputReader.sc;

public class Cafeteria {
    //Para establecer la fecha en las operaciones que se realizan  en el software
    LocalTime horaActual = LocalTime.now().withNano(0);

    //Genera un numero aletorio para cada operacion
    int numOperacion = ThreadLocalRandom.current().nextInt(100000, 999999);


    private String nombreCliente;

    // Menu Desordenado
    private HashMap<String, Double> productosDesordenados;

    // Menu Ordenado
    private TreeMap<String, Double> productosOrdenados;

    // Pedidos
    private ArrayList<String> pedidosRealizados;

    // Cola pedidos (LinkedList)
    private LinkedList<String> pedidosCola;

    public Cafeteria() {

        productosDesordenados = new HashMap<>();
        productosOrdenados = new TreeMap<>();
        pedidosRealizados = new ArrayList<>();
        pedidosCola = new LinkedList<>();

        cargarProductos();
    }

    public void cargarProductos() {

        productosDesordenados.put("Cafe", 1.20);
        productosDesordenados.put("Donuts", 2.0);
        productosDesordenados.put("Té", 1.50);
        productosDesordenados.put("Tostadas", 2.50);
        productosDesordenados.put("Capuccino", 1.20);
        productosDesordenados.put("Leche", 2.0);
        productosDesordenados.put("ColaCao", 1.50);
        productosDesordenados.put("Croissant Chocolate", 2.50);

        productosOrdenados.putAll(productosDesordenados);
    }

    public Map<String, Double> getProductosDesordenados() {

        return productosDesordenados;
    }

    public Map<String, Double> getProductosOrdenados() {
        return productosOrdenados;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /*
     Agregar nuevo pedido
     */
    public void agregarNuevoPedido(ArrayList<Producto> productos) {

        if (productos.isEmpty()) {
            System.out.println("No se han añadido productos");
            return;
        }

        String pedido = construirPedido(nombreCliente, productos);
        registroPedido(pedido);

        System.out.println("Pedido realizado con éxito");
    }

    private String construirPedido(String cliente, ArrayList<Producto> productos) {
        String resultado = cliente + "=";

        for (Producto p : productos) {
            resultado += p.getNombre() + ",";
        }

        return resultado;
    }

    private void registroPedido(String pedido) {

        pedidosRealizados.add(pedido);
        pedidosCola.add(pedido);
    }

    public ArrayList<String> getPedidosRealizados() {

        return pedidosRealizados;
    }

    public LinkedList<String> getPedidosCola() {

        return pedidosCola;
    }

    public Producto buscarProductoMenu(String entrada) {

        if (productosDesordenados.containsKey(entrada)) {
            return new Producto(entrada, productosDesordenados.get(entrada));
        }

        return null;
    }

    /*
     Atender siguiente pedido
     */
    public String pedidosAtendidos() {

        if (!pedidosCola.isEmpty()) {

            String atendido = pedidosCola.removeFirst();
            pedidosRealizados.remove(atendido);

            return atendido;
        }

        return null;
    }

    public Pagar pagarTarjeta() {
        // Proceso para pago con tarjeta
        sc.nextLine();

        CustomCLI.titulo("Introduzca el importe a cobrar");
        double importe = sc.nextDouble();

        sc.nextLine();

        CustomCLI.titulo("Introducir nombre de tarjeta");

        String nombreTarjeta = sc.nextLine();

        if (nombreTarjeta.equalsIgnoreCase("visa") || nombreTarjeta.equalsIgnoreCase("mastercard") || nombreTarjeta.equalsIgnoreCase("american express")) {

            CustomCLI.exito("tarjeta valida");


        } else {

            CustomCLI.error("tarjeta no valida");

        }

        CustomCLI.titulo("Introducir numero de tarjeta");

        String numeroTarjeta = sc.nextLine();

        if (numeroTarjeta.matches("\\d{16}")) {

            CustomCLI.exito("\n!!!Operacion realizada con exito¡¡¡");
            System.out.println("Tipo de Tarjeta: " + nombreTarjeta.toUpperCase());
            System.out.println("Numero de tarjeta: " + numeroTarjeta);

            CustomCLI.titulo("\n---DATOS DE LA OPERACION---");

            System.out.println("\nOperacion realizada a las : " + horaActual);
            System.out.println("Numero de operacion es: " + numOperacion);


        } else {
            CustomCLI.error("Numero invalido");

        }


        return null;
    }
}
