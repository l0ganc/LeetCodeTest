import java.util.ArrayList;
import java.util.List;

public class CharacterToDiget {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        System.out.println(res.remove(1));
        //System.out.println(Character.forDigit(10, 10));

        System.out.println(getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        char[] result = new char[n];
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;

        for (int i = 0; i < n; i++) {
            result[i] = Character.forDigit(nums.remove(k / factorial[n - 1 - i]), 10);
            k = k % factorial[n - 1 - i];
        }

        return new String(result);
    }
}
