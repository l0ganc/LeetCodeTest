public class StringReverse {
    public static void main(String[] args) {
        String s = " ";
        String s1 = "   I   love   Google  ";
        String[] test = s1.trim().split("\\s+");
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

        System.out.println("After reverse is : " + getRes(s1));
    }

    private static String getRes(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        int i = 0;
        for (int j = 0; j < str.length; j++) {
            if (str[j] == ' ') {
                reverse(str, i, j - 1);
                i = j + 1;
            }
        }

        // reverse the last word
        reverse(str, i, str.length - 1);

        // reverse the whole sentence
        reverse(str, 0, str.length - 1);

        return String.valueOf(str);
    }

    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }


}
