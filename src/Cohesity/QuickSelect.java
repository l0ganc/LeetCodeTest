package Cohesity;

/**
 * 选出无重复的一组数组中的第k小的元素
 * Quick sort
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 6;
        System.out.println("第" + k + "小的数是: " + findKthSmallest(nums, k));
    }

    private static int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int position = partition(nums, left, right);
            if (position + 1 == k) {
                return nums[position];
            } else if (position + 1 < k) {
                left = position + 1;
            } else {
                right = position - 1;
            }
        }
        //return Integer.MIN_VALUE;
    }

    private static int partition (int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            } else if (nums[l] <= pivot) {
                l++;
            } else if (nums[r] >= pivot){
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
