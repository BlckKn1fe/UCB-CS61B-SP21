/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /**
     * If n is even, the next number is n/2.
     * If n is odd, the next number is 3n + 1.
     * @param n is the input number
     * @return the next expected number
     */
    public static int nextNumber(int n) {
        // when n is even
        if (n % 2 == 0) {
            return n / 2;
        }
        // when n is odd
        else {
            return 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

