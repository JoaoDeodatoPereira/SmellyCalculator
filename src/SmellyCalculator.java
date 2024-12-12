import java.util.Scanner;

public class SmellyCalculator {

    static Scanner scanner = new Scanner(System.in);
    static double num1, num2, result;
    static String operation, choice;

    public static void main(String[] args) {
        System.out.println("Welcome to the Worst Calculator!");

        System.out.println("Enter first number: ");
        num1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        num2 = scanner.nextDouble();
        System.out.println("Choose operation: (+, -, *, /): ");
        operation = scanner.next();

        if (operation.equals("+")) {
            result = num1 + num2;
            System.out.println("Result: " + result);
        } else if (operation.equals("-")) {
            result = num1 - num2;
            System.out.println("Result: " + result);
        } else if (operation.equals("*")) {
            result = num1 * num2;
            System.out.println("Result: " + result);
        } else if (operation.equals("/")) {
            if (num2 != 0) {
                result = num1 / num2;
                System.out.println("Result: " + result);
            } else {
                System.out.println("Error: Division by zero!");
            }
        } else {
            System.out.println("Invalid operation!");
        }

        System.out.println("Would you like to continue? (yes/no): ");
        choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            restartCalculator();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid input! Exiting...");
            System.exit(0);
        }
    }

    public static void dummyMethod() {
        System.out.println("This does absolutely nothing!");
    }

    public static void restartCalculator() {
        main(null);
    }
}