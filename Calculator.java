import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;
        do {
            System.out.println("Enter first number:");
            double num1 = sc.nextDouble();
            System.out.println("Enter second number:");
            double num2 = sc.nextDouble();
            System.out.println("Choose an operation: +, -, *, /");
            char operation = sc.next().charAt(0);
            double result;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    System.out.println("Addition: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("Subtraction: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("Multiply: " + result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Division: " + result);
                    } else {
                        System.out.println("Error...!");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operation.");
            }
            System.out.println("Do you want to perform another calculation? (y/n)");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}