package Microsoft_OA;

public class ReturnProperValue {
    public static void main(String[] args) {
        int[] a = new int[]{0, -1, 2, 3};
        int[] b = new int[]{-1, -1, 2, 3};
        int[] c = new int[]{0, -1, 2, 3};
        int[] d = new int[]{3, 4, 2, 3};
        int[] e = new int[]{-8878, -1, -2, 3};
        int[] f = new int[]{34, -1, 44, -8};

        System.out.println(calculateValue(a));
        System.out.println(calculateValue(b));
        System.out.println(calculateValue(c));
        System.out.println(calculateValue(d));
        System.out.println(calculateValue(e));
        System.out.println(calculateValue(f));
    }

    private static int calculateValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int negativeCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negativeCount++;
            }
        }

        if (negativeCount % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
