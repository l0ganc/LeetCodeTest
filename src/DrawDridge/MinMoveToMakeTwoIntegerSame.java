package DrawDridge;

public class MinMoveToMakeTwoIntegerSame {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{2, 2, 4};
        System.out.println("最小操作次数是：" + getMinOp(num1, num2));
    }

    private static int getMinOp(int[] num1, int[] num2) {
        int res = 0;
        for (int i = 0; i < num1.length; i++) {
            res += Math.abs(num1[i] - num2[i]);
        }
        return res;
    }
}
