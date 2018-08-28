import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long base = s.nextInt();
		long exponent = s.nextInt();
		long result = power(base, exponent);
		System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	public static long power(long base, long exponent) {
		if (exponent != 0) {
			return (base * power(base, exponent - 1));
		} else {
			return 1;
		}

	}
}
