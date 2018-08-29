
import java.util.Scanner;
/**.
 * This is solution class for given problem
 */
public class Solution {
    /**
     * This is contructor.
     */
    private Solution(){
        //This is solution
    }
    /* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            final int t = 10;
            final int se = 7;
            while (j != 0) {
                if ((j % t) == se) {
                    count = count + 1;
                }
                j = j / t;
            }


        }
        System.out.println(count);

    }
}