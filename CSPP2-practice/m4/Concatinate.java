import java.util.Scanner;
public class Concatinate{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter your name: ");
		String s1 = scan.nextLine();
		String s2 = "Hello ";
		String s3 = "!";
		System.out.println(s2.concat(s1.concat(s3)));
	}

}