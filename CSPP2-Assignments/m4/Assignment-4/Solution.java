import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){
        //This is solution contrutor
    }
    /**
     * This is main method
     *
     * @param      args  Arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    /**.
     * Method to reverse the given string
     *
     * @param      str   string
     *
     * @return     return the reversed string
     */
    public static final String reverseString(final String str) {
        String reverseStr = "";
        for (int i = 0; i < str.length(); i++) {
            reverseStr = str.charAt(i) + reverseStr;
        }
        return reverseStr;
    }

}
