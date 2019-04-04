package Lumi_Labs;

import java.util.Arrays;
import java.util.Random;

public class ReturnKDistinceRandomNum {
    /**
     * 给一组数（没有相同的），随机返回k个不同的数，很经典的随机播放音乐的问题，但是我忘了那个小trick
     * 最后具体到了输入 int k 和 int[] list ，返回一个List
     */

    public static int[] getKDistinctNum(int k, int[] list) {
        int[] res = new int[k];
        Random rdm = new Random();
        int len = list.length;

        for (int i = 0; i < k; i++) {
            int index = rdm.nextInt(len - i);
            int lastIndex = len - 1 - i;
            if (index != lastIndex) {
                swap(list, index, lastIndex);
            }
            res[i] = list[lastIndex];
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9,10};
        int k = 10;
        System.out.println(Arrays.toString(getKDistinctNum(k, list)));
    }
}
