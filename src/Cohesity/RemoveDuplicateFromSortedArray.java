package Cohesity;

public class RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int slow  = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 3};
        System.out.println(removeDuplicates(nums));
    }
}
