import java.util.InputMismatchException;
import java.util.Scanner;

    class DivideDemo {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            try {
                System.out.print("Enter first integer: ");
                int a = sc.nextInt();            // throws InputMismatchException if not a number
                System.out.print("Enter second integer: ");
                int b = sc.nextInt();

                System.out.println("Result: " + (a / b));   // throws ArithmeticException if b is 0
            } catch (InputMismatchException e) {
                System.out.println("Error: please enter whole numbers only.");
            } catch (ArithmeticException e) {
                System.out.println("Error: cannot divide by zero.");
            } finally {
                sc.close();   // always runs, whether or not an exception happened
            }
        }
    }

