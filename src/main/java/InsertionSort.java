import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort{
    public static void main(String[] args){
        System.out.print("\n\nSize of input array: ");
        Scanner scanner = new Scanner(System.in);
        int inputArraySize = scanner.nextInt();
        
        // Input numbers
        System.out.println("\nInput numbers(integer format): ");

        int[] numbers = new int[inputArraySize];
        for(int i = 0; i < inputArraySize; i++){
            numbers[i] = scanner.nextInt();
        }

        scanner.close();
        System.out.format("\nInput sequence: %s", Arrays.toString(numbers));

        // Perform insertion sort.
        performInsertionSort(numbers);

        // Show sorted elements to the user.
        System.out.format("\n\nSorted sequence: %s\n", Arrays.toString(numbers));
    }

    private static void performInsertionSort(int[] numbers){
        for(int i = 1; i < numbers.length; i++){
            int key = numbers[i];
            int j = i-1;
            while(j >= 0 && numbers[j] > key){
                numbers[j+1] = numbers[j];
                j--;
            }
            numbers[++j] = key;
        }
    }
}