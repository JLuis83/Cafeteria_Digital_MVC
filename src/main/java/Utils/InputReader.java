package Utils;

import java.util.Scanner;

public class InputReader {

    public static Scanner sc = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine().trim();
    }

    public static int leerEntero(String mensaje) {

        System.out.println(mensaje);

        while (!sc.hasNextInt()) {
            System.out.println("Introduce un número válido");
            sc.next();
        }

        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static void cerrar() {
        sc.close();
    }
}
