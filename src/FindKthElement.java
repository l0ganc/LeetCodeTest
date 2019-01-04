public class FindKthElement {
    public static void main(String[] args) {
        int k = 2;
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println("第 " + k + " 大的元素是 : " + getRes(arr, k));
    }

    private static int getRes(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
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
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            } else if (nums[l] >= pivot) {
                l++;
            } else if (nums[r] <= pivot){
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
