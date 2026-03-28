import java.util.Arrays;
import java.util.Scanner;
public class NumericArraySorter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of array elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n]; 
        for(int i = 0; i < n; i++){
            System.out.print("Enter element " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        double average = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}