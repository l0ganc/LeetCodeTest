public class CountBits {
    public static void main(String[] args) {
        int number = 8;
        System.out.println(number + "'s bit count is " + getRes(number));
        int[] array = new int[3];
    }

    private static int getRes(int number) {
        int res = number ^ 0;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if (((res >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
