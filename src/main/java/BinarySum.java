import java.util.Arrays;

/**
 * Solution for exercise: 2.1-4 (P-22/23)
 */
public class BinarySum{
    public static void main(String[] args){
        int n = 12;
        int[] a = new int[]{1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1};
        int[] b = new int[]{1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0};
        int[] c = sum(a, b, n);

        System.out.format("a: %s\nb: %s\n\nsum: %s", 
                Arrays.toString(a),
                Arrays.toString(b),
                Arrays.toString(c));
    }

    private static int[] sum(int[] a, int[] b, int n){
        int[] c = new int[n+1];
        int carry = 0;
        for(int i = n-1; i >= 0; i--){
            int sum = a[i]+b[i]+carry;
            switch(sum){
                case 2: 
                    c[i+1] = 0;
                    carry = 1;
                    break;
                case 3: 
                    c[i+1] = 1;
                    carry = 1;
                    break;
                default:
                    c[i+1] = sum;
                    carry = 0;
                    break;
            }
        }
        c[0] = carry;
        return c;
    }
}