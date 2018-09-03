import java.util.Scanner;
/**.
 * This is input validator class, it validates the input
 */
class InputValidator {
    String value;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(String input) {
        this.value = input;
    }
    /**.
     * Checks for  valid data
     *
     * @return     { Boolean value }
     */
    boolean validateData() {
        String x = this.value;
        int sum = x.length();
        if (sum >= 6) {
            return true;
        }
        return false;
    }
}
/**.
 * This is solution class
 */
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
