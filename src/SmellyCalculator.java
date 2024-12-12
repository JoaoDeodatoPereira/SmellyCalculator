import java.util.Scanner;

public class SmellyCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Refactored Calculator!");

        boolean keepRunning = true;

        while (keepRunning) {
            double num1 = getNumber(scanner, "Enter first number: ");
            double num2 = getNumber(scanner, "Enter second number: ");
            String operation = getOperation(scanner);

            double result = performOperation(num1, num2, operation);
            if (!Double.isNaN(result)) {
                System.out.println("The result is: " + result);
            }

            keepRunning = askToContinue(scanner);
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static double getNumber(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String getOperation(Scanner scanner) {
        System.out.println("Choose operation: (+, -, *, /): ");
        String operation = scanner.next();
        while (!isValidOperation(operation)) {
            System.out.println("Invalid operation. Please choose one of (+, -, *, /): ");
            operation = scanner.next();
        }
        return operation;
    }

    private static boolean isValidOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }

    private static double performOperation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return Double.NaN;
                }
            default:
                System.out.println("Invalid operation!");
                return Double.NaN;
        }
    }

    private static boolean askToContinue(Scanner scanner) {
        System.out.println("Would you like to perform another operation? (yes/no): ");
        String choice = scanner.next();
        while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
            System.out.println("Invalid input. Please enter 'yes' or 'no': ");
            choice = scanner.next();
        }
        return choice.equalsIgnoreCase("yes");
    }
}
