import java.util.HashMap;
import java.util.Map;

/**
 *Intuition:
 * Write a helper using sliding window,
 * to get the number of subarrays with at most K distinct elements.
 * Then f(exactly K) = f(atMost K) - f(atMost K-1).
 *
 * Of course, you can merge 2 for loop into ones, if you like.
 *
 * Time Complexity:
 * O(N)
 */
public class LC992SubarrayswithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }

    public static int atMost(int[] A, int K) {
        int i = 0;
        int res = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            if (count.getOrDefault(A[j], 0) == 0) {
                K--;
            }
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) {
                    K++;
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(A, 2));
    }
}
