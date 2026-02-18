package Modelo;

import java.time.LocalDate;

/**
 * Proceso para un pago realizado con tarjeta.
 */

public class Pagar {

    private double importe;
    private LocalDate fecha;


    public Pagar(double importe,LocalDate fecha){

        this.importe = importe;
        this.fecha = LocalDate.now();
    }

    public double getImporte(){
        return importe;
    }

    public LocalDate getfecha(){
        return fecha;
    }
}
