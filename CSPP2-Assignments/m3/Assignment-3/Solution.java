
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(final String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1,n2));
    }
    /*
	Need to write the gcd function and print the output.
	*/
	public final static int gcd( final int n1, final int n2){
		int hcf = 1;
		for (int i = 1; i<=n1 && i<= n2; i++){
			if (((n1%i)==0)&&((n2%i)==0)){
				hcf = i;
			}
		}
		return hcf;
	}
}
