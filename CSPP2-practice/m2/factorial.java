import java.util.Scanner;
public class factorial{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(); 
		System.out.println(fact(a));
	}
	public static int fact(int n){
		if (n == 0){
			return 1;
		}
		else{
			return n*fact(n-1);
		}
		
	}
}