package CafeteriaDig;

import Lógica.Cafeteria;
import Vista.CafeteriaVistaCLI;

public class Main {

    public static void main(String[] args) {

        Cafeteria service = new Cafeteria();
        CafeteriaVistaCLI vista = new CafeteriaVistaCLI(service);

       vista.iniciar();
    }
}
