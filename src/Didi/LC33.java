package Didi;

public class LC33 {
    // 33. Search in Rotated Sorted Array
    // binary seaach
    // time = O(logn) space = O(1)

    /**
     *
     * @param nums
     * @param target
     * @return
     *
     *
     *   4 5 6 7 0 1 2
     *   s    mid      e
     */

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            }

            // first half
            if (nums[start] < nums[mid])  {
                if (nums[start] <= target & target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        int[] nums2 = new int[]{4,5,6,7,0,1,2};
        int[] nums3 = new int[]{1};
        System.out.println(search(nums1, 0));
        System.out.println(search(nums2, 3));
        System.out.println(search(nums3, 0));
    }
}
