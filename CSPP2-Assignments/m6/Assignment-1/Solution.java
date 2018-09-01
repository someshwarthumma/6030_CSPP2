import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
	// write your code here
    	for(int i =3; i <= n; i = i+2){
    		if(isNotPrime(i)){
    			System.out.println(i);
    		}
    	}
    }

    static boolean isNotPrime(final int num){
    	int flag =0;
    	for(int i = 1;i<=num; i++){
    		if (num%i==0){
    			flag = flag + 1;
    		}
    	}
    	if(flag == 2){
    		return false;
    	}else{
    		return true;
    	}
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

