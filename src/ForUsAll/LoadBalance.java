package ForUsAll;

public class LoadBalance {
    //第二题更简单了，load balancer，一个数组丢掉两个元素，会把数组分为三份，这三份和相同就返回true，要不是false
    //【3，1，7，5，15，16，4，6，3，7，0】
    //3 + 1 + 7 + 5 = 16 = 6 + 3 + 7  + 0
    //返回true
    //有性能要求，我给的O(n)，虽然其实走了两遍吧

    public static boolean loadbalancer(int[] input) {
        int[] leftsum = new int[input.length];
        int[] rightsum = new int[input.length];
        leftsum[0] = input[0];
        rightsum[rightsum.length - 1] = input[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            leftsum[i] = leftsum[i - 1] + input[i];
        }
        for (int i = input.length - 2; i >= 0; i--) {
            rightsum[i] = rightsum[i + 1] + input[i];
        }
        int totalsum = rightsum[0];
        int lindex = 1;
        int rindex = input.length - 2;
        while (lindex < rindex) {
            int lp = leftsum[lindex - 1];
            int rp = rightsum[rindex + 1];
            int mp = totalsum - lp - rp - input[lindex] - input[rindex];
            if (lp < rp) {
                lindex++;
            } else if (lp > rp) {
                rindex--;
            } else {
                if (lp == mp) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
