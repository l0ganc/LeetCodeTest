public class RemoveSomeCharsInAString {
    /**
     * remove a/some particular chars from a string
     * Example string input = "student", remove "u and n"  --> output: "stdet"
     * @param args
     */
    public static void main(String[] args) {
        String s = "student";
        System.out.println("after remove u and n is : " + getRes(s));

    }

    /**
     * 2个挡板，3个区域，同向而行
     * i = 0: all letters to the left-hand side of i(not including i) are all processed letters that should not be removed(slow)
     * j = 0: j is the current index to move(fast) all letters in (i, j) are all area that we do not care (empty space xxx)
     * (j, size - 1) (unknown area to explore)
     */
    private static String getRes(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == 'u' || s.charAt(j) == 'n') {
                j++;
            } else {
                s = swap(s, i++, j++);
            }
        }

        return s.substring(0, i);
    }

    private static String swap(String s, int i, int j) {
        char[] input = s.toCharArray();
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;

        return String.valueOf(input);
    }
}
