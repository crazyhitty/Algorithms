import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort{
    private static final int TYPE_INSERTION_SORT=1;
    private static final int TYPE_REVERSE_INSERTION_SORT=2;

    public static void main(String[] args){
        System.out.print("\n\nSelect sort type: type 1 for normal insertion sort, or 2 for reverse insertion sort.\nSort type: ");
        Scanner scanner = new Scanner(System.in);
        int sortType = scanner.nextInt();
        if(sortType != TYPE_INSERTION_SORT && 
                sortType != TYPE_REVERSE_INSERTION_SORT){
            scanner.close();
            throw new IllegalArgumentException("Sort type undefined!");
        }

        System.out.print("\nSize of input array: ");
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
        switch (sortType) {
            case TYPE_INSERTION_SORT:
                performInsertionSort(numbers);
                break;
            case TYPE_REVERSE_INSERTION_SORT:
                performReverseInsertionSort(numbers);
                break;
        }

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

    private static void performReverseInsertionSort(int[] numbers){
        for(int i = numbers.length -2 ; i >= 0; i--){
            int key = numbers[i];
            int j = i+1;
            while(j < numbers.length && numbers[j] > key){
                numbers[j-1] = numbers[j];
                j++;
            }
            numbers[--j] = key;
        }
    }
}