import java.util.Scanner;
//import java.lang.Math;
/**
 * Class for solution.
 */
public class Solution {
    /**.
     * solution class to find the solution
     *
     * @param      args  These are arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        equation(a, b, c);
    }
    /**
     * It gives
     *
     * @param      a     integer
     * @param      b     integer
     * @param      c     integer
     */
    public static void equation(final int a, final int b, final int c) {
        double x;
        double y;
        final int z = 4;
        x = (-b + Math.sqrt((b * b) - z * a * c)) / (2 * a);
        y = (-b - Math.sqrt((b * b) - z * a * c)) / (2  * a);
        System.out.println(x + " " + y);
    }
}

