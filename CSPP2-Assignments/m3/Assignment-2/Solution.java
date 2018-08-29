
import java.util.Scanner;
/**
 * This is solution class for given problem
 */
public class Solution {
    /* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            final int t = 10;
            final int seven = 7;
            while (j != 0) {
                if ((j % t) == 7) {
                    count = count + 1;
                }
                j = j / t;
            }


        }
        System.out.println(count);

    }
}