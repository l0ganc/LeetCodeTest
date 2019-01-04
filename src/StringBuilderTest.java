public class StringBuilderTest {
    public static void main(String[] args) {
        char test = 6 + '0';
        System.out.println("test is " + test);
        int number = 155;
        System.out.println("to Hex : " + hex(155));
    }

    public static String hex(int number) {
        // Write your solution here
        if (number == 0) {
            return "0x0";
        }

        String res = "";
        while (number > 0) {
            int reminder = number % 16;
            if (reminder <= 9) {
                res += (char) (reminder + '0');
            } else {
                res += (char)('A' + reminder - 10);
            }
            number /= 16;
        }
        //res.append("x0");
        res = reverse(res, 0, res.length() - 1);
        return "0x" + res;
    }

    private static String reverse(String str, int L, int R) {
        char[] s = str.toCharArray();
        while (L < R) {
            char temp = s[L];
            s[L] = s[R];
            s[R] = temp;
            L++;
            R--;
        }
        return String.valueOf(s);

    }
}
