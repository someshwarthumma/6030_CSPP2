import java.util.Scanner;
public class bigger_equal_smaller{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		if (a >b){
			System.out.println("Bigger");}
		else if (a == b){
			System.out.println("Equal");}
		else {
			System.out.println("Smaller");
			}
		}

}