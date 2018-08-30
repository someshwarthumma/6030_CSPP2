import java.util.*;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int rowM1 = scan.nextInt();
		int columnM1 = scan.nextInt();
		int[][] matrix1 = new int[rowM1][columnM1];
		matrix1 =readMatrix(rowM1, columnM1, matrix1);
		int rowM2 = scan.nextInt();
		int columnM2 = scan.nextInt();
		int[][] matrix2 = new int[rowM2][columnM2];
		matrix2 =readMatrix(rowM2, columnM2, matrix2);
		if((rowM1==rowM2)&&(columnM1==columnM2)){
			for(int i=0; i < rowM1; i++){
				for(int j=0; j<columnM1; j++){
					matrix1[i][j] = matrix1[i][j] + matrix2[i][j];
				}
				for(int j=0; j< columnM1-1; j++){
					System.out.print(matrix1[i][j]+" ");
				}
				System.out.println(matrix1[i][columnM1-1]);
			}
		}
		else{
			System.out.println("not possible");
		}


	}
	public static int[][] readMatrix(int row, int column, int[][] matrix){
		// Scanner sc = new Scanner(System.in);
		for(int i=0;i<row; i++){
			for(int j=0; j<column; j++){
				matrix[i][j] = scan.nextInt();
			}
		}
		return matrix;
	}
}