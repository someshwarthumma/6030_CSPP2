import java.util.Scanner;
public class Average{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array size");
		int arraySize = scan.nextInt();;
		int[] array = new int[arraySize];
		System.out.println("Enter the array elements");
		for (int i=0; i<arraySize;i++){
			array[i] = scan.nextInt();
		}
		double sum = 0;
		for(int i : array){
			sum = sum + i;
		}
		System.out.println("Average: "+sum/(arraySize));

	}
}