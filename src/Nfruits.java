import java.util.HashMap;

public class Nfruits {
    private static int getMaxFruits(int[] A) {
        int counter = 0;
        int begin = 0, end = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        while (end < A.length) {
            map.put(A[end], map.getOrDefault(A[end], 0) + 1);
            if (map.get(A[end]) == 1) {
                counter++;
            }
            end++;

            while (begin < A.length && counter > 2) {
                map.put(A[begin], map.get(A[begin]) - 1);
                if (map.get(A[begin]) == 0) {
                    counter--;
                }
                begin++;
            }
            res = Math.max(res, end - begin);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 4, 3, 5, 1, 2};
        int[] arr2 = new int[]{1, 2, 1, 2, 1, 2, 1};
        int[] arr3 = new int[]{1, 2, 1, 1, 2, 1, 5, 4, 5, 5, 4, 4, 4, 5, 6};
        System.out.println(getMaxFruits(arr));
        System.out.println(getMaxFruits(arr2));
        System.out.println(getMaxFruits(arr3));
    }

}
