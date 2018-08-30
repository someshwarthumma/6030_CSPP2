import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /* Fill the main function to print resultant of addition of matrices*/
    /**.
     * This is a scanner object
     */
    private static Scanner scan = new Scanner(System.in);
    /**.
     * Constructs the object.
     */
    private Solution() {
        //This is constructor
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        int rowM1 = scan.nextInt();
        int columnM1 = scan.nextInt();
        int[][] mat1 = new int[rowM1][columnM1];
        mat1 = readMatrix(rowM1, columnM1, mat1);
        int rowM2 = scan.nextInt();
        int columnM2 = scan.nextInt();
        int[][] mat2 = new int[rowM2][columnM2];
        mat2 = readMatrix(rowM2, columnM2, mat2);
        if ((rowM1 == rowM2) && (columnM1 == columnM2)) {
            for (int i = 0; i < rowM1; i++) {
                for (int j = 0; j < columnM1; j++) {
                    mat1[i][j] = mat1[i][j] + mat2[i][j];
                }
                for (int j = 0; j < columnM1 - 1; j++) {
                    System.out.print(mat1[i][j] + " ");
                }
                System.out.println(mat1[i][columnM1 - 1]);
            }
        } else {
            System.out.println("not possible");
        }


    }
    /**.
     * Reads a matrix.
     *
     * @param      row     The row
     * @param      column  The column
     * @param      matrix  The matrix
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] readMatrix(final int row,
                                     final int column,
                                     final int[][] matrix) {
        // Scanner sc = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        return matrix;
    }
}