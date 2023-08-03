import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program computes the square root of any non-negative number, using Newton's
 * iteration, given a user's desired epsilon value, and number.
 *
 * @author Omar Takruri
 *
 */
public final class Newton3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     *
     * @param x
     *            non-negative number to compute square root of
     * @param epsilon
     *            non-negative value to determine the desired error (epsilon)
     *            value
     * @return estimate of square root, or 0.0 if x is initially 0.0
     */
    private static double sqrt(double x, double epsilon) {

        double guess = x;
        if (x != 0.0) {
            while (Math.abs(guess * guess - x) / x >= epsilon * epsilon) {
                guess = (guess + x / guess) / 2.0;
            }
        }

        return guess;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        String response; //To see if user wants to continue or not.
        double number;

        out.print("Do you with to calculate a square root? (y/n): ");
        response = in.nextLine().trim().toLowerCase();

        while (response.equals("y")) {

            out.print("Enter the desired epsilon value: ");
            double epsilon = Double.parseDouble(in.nextLine());

            out.print("Enter a positive number: ");
            number = Double.parseDouble(in.nextLine());

            double squareRoot = sqrt(number, epsilon);
            out.print("Square root: ");
            out.println(squareRoot);
            out.print("Do you with to calculate a square root? (y/n): ");
            response = in.nextLine().trim().toLowerCase();
        }

        in.close();
        out.close();
    }

}
