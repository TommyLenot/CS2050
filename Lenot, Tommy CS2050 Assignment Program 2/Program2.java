/*
 * Your name: Tommy Lenot
 * Description: CS2050 Program2 Assignment
 */

public class Program2 {

    // TODO #1
    public static double add(double a, double b) {
        return a + b;
    }

    // TODO #2
    public static double subtract(double a, double b) {
        return a - b;
    }

    // TODO #3
    public static double multiply(double a, double b) {
        return a * b;
    }

    // TODO #4
    public static double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // TODO #5 assume right triangle
    public static double sinOfAngle(double oppSide, double hyp) {
        if (hyp == 0) {
            throw new ArithmeticException("Hypotenuse cannot be zero when calculating sine.");
        }
        return oppSide / hyp;  // returns the sine value.
    }

    // TODO #6 assume right triangle
    public static double hypOfTriangle(double sideA, double sideB) {
        return Math.sqrt(sideA * sideA + sideB * sideB);
    }

    public static void main(String[] args) {
        // Example for demonstration:
        System.out.println("Add: " + add(5, 3));
        System.out.println("Subtract: " + subtract(5, 3));
        System.out.println("Multiply: " + multiply(5, 3));
        System.out.println("Divide: " + divide(5, 3));
        System.out.println("Sine of Angle (3.0, 4.1): " + sinOfAngle(3.0, 4.1));
        System.out.println("Hypotenuse of Triangle (1.0, 1.0): " + hypOfTriangle(1.0, 1.0));
    }
}
