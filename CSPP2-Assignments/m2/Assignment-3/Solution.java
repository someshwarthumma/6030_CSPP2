import java.util.Scanner;
/**.
 * This is main class for solution
 */
public final class Solution {
	/**.
	 * This is constructor
	 */
	private Solution(){
		// This is private
	}
	/**.
	 *This is main method
	 *
	 * @param      args  this is argument
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long base = s.nextInt();
		long exponent = s.nextInt();
		long result = power(base, exponent);
		System.out.println(result);
	}
	/**.
	 * To calculate the power of a given base upto given exponent
	 *
	 * @param      base      long
	 * @param      exponent  long
	 *
	 * @return     It return the long type 
	 */
	public static long power(long base, long exponent) {
		if (exponent != 0) {
			return (base * power(base, exponent - 1));
		} else {
			return 1;
		}

	}
}
