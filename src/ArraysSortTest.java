import java.util.Arrays;

public class ArraysSortTest {
    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 5, 1, 2, 9, 0, -1};
        Arrays.sort(test, 3, test.length);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
