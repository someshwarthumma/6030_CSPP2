import java.util.Scanner;
/**.
 * This is input validator class, it validates the input
 */
class InputValidator {
    /**.
     * This is variable for holding the value of a variable
     */
    private String value;
    /**.
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        this.value = input;
    }
    /**.
     * Checks for  valid data
     *
     * @return     { Boolean value }
     */
    boolean validateData() {
        /**.
         * This is temporary variable
         */
        String x = this.value;
        int sum = x.length();
        final int six = 6;
        if (sum >= six) {
            return true;
        }
        return false;
    }
}
/**.
 * This is solution class
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //This is solution
    }
    /**.
     * This is main method
     *
     * @param      args  Argument
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        InputValidator inPut = new InputValidator(input);
        System.out.println(inPut.validateData());

    }

}
