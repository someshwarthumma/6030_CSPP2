import java.util.Scanner;
public class degrees_to_fahrenheit{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int degrees = scan.nextInt();
		double fahrenheit = degrees*1.8 + 32;
		System.out.println(fahrenheit);
	}
}