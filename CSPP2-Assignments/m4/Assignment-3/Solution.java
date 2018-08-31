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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**.
     * { function_description }
     *
     * @param      s     string
     *
     * @return     integer
     */
    public static int binaryToDecimal(final String s) {
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = Integer.parseInt(s.charAt(i) + "");
        }
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum = sum + (int) (num[i] * Math.pow(2,
                        ((s.length()) - (i + 1))));
        }
        return sum;
    }

}
