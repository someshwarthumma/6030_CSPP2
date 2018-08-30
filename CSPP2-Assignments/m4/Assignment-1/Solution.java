import java.util.Scanner;
//This is solution class
public final class Solution {
    /**.
     * Private constructor
     */
    private Solution() {
        //This is constructor
    }
    /**.
     * This is main method
     *
     * @param      args  Argument
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
