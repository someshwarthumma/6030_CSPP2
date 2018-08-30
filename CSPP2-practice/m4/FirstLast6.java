import java.util.Scanner;
public class FirstLast6{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array size");
		int arraySize = scan.nextInt();;
		int[] array = new int[arraySize];
		System.out.println("Enter the array elements");
		for (int i=0; i<arraySize;i++){
			array[i] = scan.nextInt();
		}
		if ((array[0]==6) || (array[arraySize-1]==6)){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}

	}
}