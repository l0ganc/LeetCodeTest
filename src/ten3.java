import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ten3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int golbalMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temSum = arr[0];

        }
    }
}
