import currencyConversion.service.ServiceAPI;

import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("Welcome! To the currency converter!");
        System.out.println("-----------------------------------");
        System.out.println("""
                        [1] Dollar -> Argentine currency
                        [2] Dollar -> Colombian currency
                        [3] Dollar -> Real
                        [4] EUR -> Dollar
                        [5] EUR -> Argentine currency
                        [6] EUR -> BRL
                        [7] Exit
                        """);
    }

    public static void connect(String baseValue, String targetValue) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("How much? ");
            double value = scanner.nextDouble();

            ServiceAPI serviceAPI = new ServiceAPI(baseValue, targetValue, value);
        } catch (Exception e) {
            System.out.println("Try again.");
            System.out.println("Only numbers!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte choice = 0;

        while (true) {

            try {
                menu();
                choice = scanner.nextByte();
            }
            catch (Exception e) {
                System.out.println("Try again.");
                System.out.println("Only numbers!");
            }

            if (choice == 7) {
                System.out.println("Program successfully completed");
                break;
            }

            switch (choice)
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
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}