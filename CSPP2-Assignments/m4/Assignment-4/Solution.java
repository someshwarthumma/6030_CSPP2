
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);
		
	}
	public static String reverseString(String str){
		String reverseStr = "";
		for(int i =0; i < str.length(); i++){
			reverseStr = str.charAt(i) + reverseStr;
		}
		return reverseStr;
	}

}
