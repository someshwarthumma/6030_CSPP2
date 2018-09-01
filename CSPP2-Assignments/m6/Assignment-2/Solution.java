import java.util.Scanner;
/**.
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**.
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */

    static int[][] roundHundred(final int[][] a, 
                                final int rows, 
                                final int columns) {

        // write ypur code here
        final int fifty = 50;
        final int hun = 100;
        final int sixHun = 600;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                for (int mul100 = 0; mul100 <= sixHun; mul100 = mul100 + hun) {
                    if ((mul100 <= a[row][col])
                    && (a[row][col] < mul100 + fifty)) {
                        a[row][col] = mul100;
                    }
                    if ((mul100 + fifty <= a[row][col])
                    && (a[row][col] < mul100 + hun)) {
                        a[row][col] = mul100 + hun;
                    }
                }
            }
        }
        return a;
    }
    /**.
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
