import java.util.Scanner;
/**.
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**.
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**.
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      number     n value
     */
    static void oddComposites(final int number) {
        final int three = 3;
        for (int index = three; index <= number; index = index + 2) {
            if (isNotPrime(index)) {
                System.out.println(index);
            }
        }
    }
    /**.
     * Determines if not prime.
     *
     * @param      num   input number,which is integer
     *
     * @return     True if not prime, False otherwise.
     */
    static boolean isNotPrime(final int num) {
        int count = 0;
        for (int index = 1; index <= num; index++) {
            if (num % index == 0) {
                count = count + 1;
            }
        }
        if (count == 2) {
            return false;
        }
        return true;
    }
    /**.
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
