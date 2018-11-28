public class FindMissingNunber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println("The missing num is : " + getRes(nums));
    }

    private static int getRes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = 0;
        int n = nums.length;

        for (int num : nums) {
            res ^= num;
        }

        for (int i = 0; i <= n; i++) {
            res ^= i;
        }

        return res;
    }
}
