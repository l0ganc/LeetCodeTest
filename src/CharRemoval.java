public class CharRemoval {
    public static void main(String[] args) {
        String input = "   abc  ed  ef  ";
        System.out.println("The final result string is : " + getRes(input));
    }

    /**
     * remove all leading/trailing and duplicate empty spaces (only leave one empty space if duplicated spaces happen)
     * from the input string
     *
     * 还是用两个挡板的思路来解决
     */
    private static String getRes(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        int slow = 0;
        int fast = 0;
        int wordCount = 0;    // special case for the 1st word

        String res = "";
//        while (true) {
//            while (fast < input.length() && input.charAt(fast) == ' ') {
//                fast++;
//            }
//
//            if (fast == input.length()) {
//                break;
//            }
//
//            if (wordCount > 0) {
//                String
//            }
//        }

        return res;
    }


}
