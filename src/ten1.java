import java.util.Scanner;

public class ten1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();

        int len = s.length();
        if (k > len) {
            System.out.println(0);
        }

        int res = 0;
        for (int i = k; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                String temp = s.substring(j, j + i);
                int tempCount = 0;
                for (int m = 0; m < temp.length(); m++) {
                    if (temp.charAt(m) == '1') {
                        tempCount++;
                    }
                }
                if (tempCount == k) {
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
