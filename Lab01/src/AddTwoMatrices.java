import java.util.Scanner;
public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Number of columns: ");
        int cols = scanner.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        System.out.println("Enter matrix A:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter matrix B:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sum[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("Result:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}