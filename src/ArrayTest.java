public class ArrayTest {
    static final int ASCII_SIZE = 256;
    public static void main(String[] args) {
        int[] count = new int[ASCII_SIZE];
        String s = "aest";
        char frequent = s.charAt(0);
        count[frequent] = 1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                System.out.println(i);
            }
        }
    }
}
