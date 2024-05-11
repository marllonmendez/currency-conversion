import currencyConversion.service.ServiceAPI;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Boas Vindas 😊");
        System.out.println("""
                        -----------------------------------
                        [1] Dólar -> Peso Argentino
                        [2] Dólar -> Peso Colombiano
                        [3] Dólar -> Real Brasileiro
                        [4] Euro -> Dólar
                        [5] Euro -> Peso Argentino
                        [6] Euro -> Real Brasileiro
                        [7] Sair
                        -----------------------------------
                        """);
        System.out.println("Escolha uma opção: ");
    }

    public static void connect(String baseValue, String targetValue) {
        try {

            System.out.println("Quanto? ");
            double value = scanner.nextDouble();

            ServiceAPI serviceAPI = new ServiceAPI(baseValue, targetValue, value);
        } catch (Exception e) {
            System.out.println("Tente Novamente!");
            System.out.println("Apenas Números!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte option = 0;

        while (true) {

            try {
                menu();
                option = scanner.nextByte();
            }
            catch (Exception e) {
                System.out.println("Tente Novamente!");
                System.out.println("Apenas Números!");
            }

            if (option == 7) {
                System.out.println("Até a próxima 👋");
                break;
            }

            switch (option)
            {
                case 1:
                    connect("USD", "ARS");
                    break;
                case 2:
                    connect("USD", "COP");
                    break;
                case 3:
                    connect("USD", "BRL");
                    break;
                case 4:
                    connect("EUR", "USD");
                    break;
                case 5:
                    connect("EUR", "ARS");
                    break;
                case 6:
                    connect("EUR", "BRL");
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }
    }
}