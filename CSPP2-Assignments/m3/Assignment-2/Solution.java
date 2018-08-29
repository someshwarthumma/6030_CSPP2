
import java.util.Scanner;
/**.
 * This is solution class for given problem
 */
public final class Solution {
    /**
     * This is contructor.
     */
    private Solution() {
        //This is solution
    }
    /* Fill the main function to print the number of 7's between 1 to n*/
    /**.
     * This is initialisation for solution
     *
     * @param      args  none
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            final int ten = 10;
            final int seven = 7;
            while (temp != 0) {
                if ((temp % ten) == seven) {
                    count = count + 1;
                }
                temp = temp / ten;
            }


        }
        System.out.println(count);

    }
}
