package Vista;

public class CustomCLI {

        private static final String RESET = "\u001B[0m";
        private static final String ROJO = "\u001B[31m";
        private static final String VERDE = "\u001B[32m";
        private static final String AZUL = "\u001B[34m";

        public static void exito(String mensaje) {
            System.out.println(VERDE + mensaje + RESET);
        }

        public static void error(String mensaje) {
            System.out.println(ROJO + mensaje + RESET);
        }

        public static void titulo(String mensaje) {
            System.out.println(AZUL + "=== " + mensaje + " ===" + RESET);
        }
    }

