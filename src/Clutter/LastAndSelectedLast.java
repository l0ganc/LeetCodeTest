package Clutter;

public class LastAndSelectedLast {
    public static String getLastTwoChars(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }

        return s.charAt(s.length() - 1) + " " + s.charAt(s.length() - 2);
    }

    public static void main(String[] args) {
        System.out.println(getLastTwoChars("APPLE"));
        System.out.println(getLastTwoChars("bat"));
    }
}
