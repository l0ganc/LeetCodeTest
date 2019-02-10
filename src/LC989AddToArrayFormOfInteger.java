import java.util.ArrayList;
import java.util.List;

public class LC989AddToArrayFormOfInteger {

    /**
     * Take K as a carry.
     * Add it to the lowest digit,
     * update carry K,
     * and keep going to higher digit.
     * time complexity is O(N)
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();

        for (int i = A.length - 1; i >= 0; i--) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }

        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A1 = {9,9,9,9,9,9,9,9,9,9};
        int  k1 = 1;
        List<Integer> res = addToArrayForm(A1, k1);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }

    }
}
