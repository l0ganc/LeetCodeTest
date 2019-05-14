package ForUsAll;

public class NoMoreThanThree {
    /**
     * 第一题，给Integer A and B，输出一个字符串含有A个'a' B个'b'，但是不能有连续三个相同字母
     * A = 4, B = 1只有一个解答，aabaa，其他的有多个正确解答，你只需要输出一个,
     */

    public static String printAB(int n, int m) {
        StringBuilder sb = new StringBuilder();
        if (n > m) {
            while (m * 2 > n) {
                sb.append("aa");
                sb.append("bb");
                m = m - 2;
                n = n - 2;
            }
            while (n > 0 && m > 0) {
                sb.append("aa");
                sb.append("b");
                m = m - 1;
                n = n - 2;
            }
            if (n > 0) {
                sb.append("aa");
            }
            return sb.toString();
        }
        if (m > n) {
            while (n * 2 > m) {
                sb.append("bb");
                sb.append("aa");
                m = m - 2;
                n = n - 2;
            }
            while (n > 0 && m > 0) {
                sb.append("bb");
                sb.append("a");
                m = m - 1;
                n = n - 2;
            }
            if (m > 0) {
                sb.append("bb");
            }
            return sb.toString();
        }
        return sb.toString();
    }
}
