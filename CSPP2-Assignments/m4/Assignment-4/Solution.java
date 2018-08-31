import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //This is solution contrutor
    }
    /**.
     * This is main method
     *
     * @param      args  Arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String reversedStr = reverseString(str);
        System.out.println(reversedStr);

    }
    /**.
     * Method to reverse the given string
     *
     * @param      str   string
     *
     * @return     return the reversed string
     */
    public static String reverseString(final String str) {
        String reverseStr = "";
        for (int index = 0; index < str.length(); index++) {
            reverseStr = str.charAt(index) + reverseStr;
        }
        return reverseStr;
    }

}
