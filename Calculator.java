import java.util.Scanner;

public class Calculator {

    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("❌ Cannot divide by zero");
            return 0;
        }
        return a / b;
    }

    static double modulus(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\n Calculator");

            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.println("\nSelect Operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.print("Enter choice (1-5): ");
            int op = sc.nextInt();

            double result = switch (op) {
                case 1 -> add(num1, num2);
                case 2 -> subtract(num1, num2);
                case 3 -> multiply(num1, num2);
                case 4 -> divide(num1, num2);
                case 5 -> modulus(num1, num2);
                default -> {
                    System.out.println("❌ Invalid choice");
                    yield 0;
                }
            };

            // 🔹 No decimal for addition
            if (op == 1 && result % 1 == 0) {
                System.out.println("Result = " + (int) result);
            } else {
                System.out.println("Result = " + result);
            }

            System.out.print("\nDo you want to calculate again? (Y/N): ");
            choice = sc.next().toUpperCase().charAt(0);

        } while (choice == 'Y');

        System.out.println("👋 Calculator closed.");
        sc.close();
    }
}
