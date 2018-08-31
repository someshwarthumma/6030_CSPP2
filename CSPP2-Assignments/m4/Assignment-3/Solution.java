import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * This is construction
     */
    private Solution() {
        //This is solution constructor
    }
    /**.
     * { function_description }
     *
     * @param      args  These are arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalNumbers = scan.nextInt();
        scan.nextLine();
        for (int index = 0; index < totalNumbers; index++) {
            String line = scan.nextLine();
            int result = binaryToDecimal(line);
            System.out.println(result);
        }
    }
    /**.
     * { function_description }
     *
     * @param      s     string
     *
     * @return     integer
     */
    public static int binaryToDecimal(final String line) {
        int[] numArray = new int[line.length()];
        for (int index = 0; index < line.length(); index++) {
            numArray[index] = Integer.parseInt(line.charAt(index) + "");
        }
        int sum = 0;
        for (int index = line.length() - 1; index >= 0; index--) {
            sum = sum + (int) (numArray[index] * Math.pow(2,
                        ((line.length()) - (index + 1))));
        }
        return sum;
    }

}
