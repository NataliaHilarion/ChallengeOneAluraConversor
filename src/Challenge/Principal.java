package Challenge;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Busqueda consulta = new Busqueda();
        Scanner teclado = new Scanner(System.in);
        int eleccion = 0;
        long valorFinal;

        while (eleccion != 7) {
            System.out.println("**********************************************");
            System.out.println("Sea Bienvenido al conversor de moneda :) \n");
            System.out.println("""
                1. Dolar => Peso argentino
                2. Peso argentino => Dolar
                3. Dolar => Real brasileño
                4. Real brasileño => Dolar
                5. Dolar => Peso colombiano
                6. Peso colombiano => Dolar
                7. Salir""");

            System.out.println("Elija una opcion valida: ");
            eleccion = teclado.nextInt();
            if (eleccion == 7) {
                break;
            }

            System.out.println("Ingresa el valor que deseas convertir: ");
            int cant = teclado.nextInt();

            String baseCode = "", targetCode = "";
            switch (eleccion) {
                case 1 -> {
                    baseCode = "USD";
                    targetCode = "ARS";
                }
                case 2 -> {
                    baseCode = "ARS";
                    targetCode = "USD";
                }
                case 3 -> {
                    baseCode = "USD";
                    targetCode = "BRL";
                }
                case 4 -> {
                    baseCode = "BRL";
                    targetCode = "USD";
                }
                case 5 -> {
                    baseCode = "USD";
                    targetCode = "COP";
                }
                case 6 -> {
                    baseCode = "COP";
                    targetCode = "USD";
                }
                default -> System.out.println("El valor ingresado no es válido, por favor elija una opción de 1 a 7");
            }

            if (!baseCode.isEmpty()) {
                double tasaConversion = consulta.busquedaMoneda(baseCode, targetCode);
                valorFinal = (long) (cant * tasaConversion);
                System.out.println("El valor de " + cant + " [" + baseCode + "] corresponde al valor final de " + valorFinal + " [" + targetCode + "]");
            }
        }

        System.out.println("***************************************************");
        System.out.println("¡Hasta Pronto!");
    }
}
