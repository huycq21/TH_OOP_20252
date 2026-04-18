package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Triangle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }

            System.out.println(); 
        }

        scanner.close();
    }
}