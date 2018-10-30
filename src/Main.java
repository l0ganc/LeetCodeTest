import java.util.Scanner;

public class Main {

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }

        int start = 0;
        long res = 0;
        int sign = 1;
        str = str.trim();
        char firstChar = str.charAt(0);

        if (firstChar == '+') {
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)(res * sign);
            }

            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)res * sign;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要转换的字符串: ");
        String str = sc.next();
        System.out.print("您输入的字符串是: " + str);
        System.out.println();
        System.out.print("转换后: " + myAtoi(str));
        System.out.println();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
