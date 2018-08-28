import java.util.Scanner;
public class area_of_Circle{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println(area(a));
	}
	public static double area(int n){
		return pi()*n*n;
	}
	public static double pi(){
		return 3.14;
	}
	
}