
import java.util.*;
public class Solution {
	/*
	Fill this main function to print maximum of given array
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
