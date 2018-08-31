
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			int res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static int binaryToDecimal(String s){
		int[] num = new int[s.length()];
		for(int i=0; i < s.length();i++){
			num[i] = Integer.parseInt(s.charAt(i)+"");
		}
		int sum = 0;
		for(int i = s.length()-1;i>=0;i--){
			sum = sum + (int)(num[i]*Math.pow(2,((s.length()) - (i +1))));
		}
		return sum;
	}

}
