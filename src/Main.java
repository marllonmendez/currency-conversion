import currencyConversion.service.ServiceAPI;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Welcome");
        System.out.println("""
        -----------------------------------
        [1] Dollar -> Argentine Peso
        [2] Dollar -> Colombian Peso
        [3] Dollar -> Brazilian Real
        [4] Euro -> Dollar
        [5] Euro -> Argentine Peso
        [6] Euro -> Brazilian Real
        [7] Exit
        -----------------------------------
        """);
        System.out.println("Choose an option:");
    }

    public static void connect(String baseValue, String targetValue) {
        try {

            System.out.println("How much is it: ");
            double value = scanner.nextDouble();

            ServiceAPI serviceAPI = new ServiceAPI(baseValue, targetValue, value);
        } catch (Exception e) {
            System.out.println("Tente Novamente!");
            System.out.println("Only numbers!");
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
                System.out.println("Try again!");
                System.out.println("Only numbers!");
            }

            if (option == 7) {
                System.out.println("See you leter");
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
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}