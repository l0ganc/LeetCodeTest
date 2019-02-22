package Mathworks;

/**
 * a = "abc"
 * b = "def"
 *
 * return "adbecf"
 */
public class MergeString {

    public static String getMergeString(String a, String b) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < a.length() && j < b.length()) {
            sb.append(a.charAt(i++));
            sb.append(b.charAt(j++));
        }

        while (i < a.length()) {
            sb.append(a.charAt(i++));
        }

        while (j < b.length()) {
            sb.append(b.charAt(j++));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        String c = "stuvwx";
        System.out.println(getMergeString(a, b));
        System.out.println(getMergeString(a, c));
    }
}
