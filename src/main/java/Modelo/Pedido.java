package Modelo;


import java.util.ArrayList;

public class Pedido {

    private final String cliente;
    private final ArrayList<Producto> producto;

    public Pedido(String cliente, ArrayList<Producto> productos){

        this.cliente = cliente;
        this.producto= new ArrayList<>();
    }

}



