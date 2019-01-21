public class LC418SentenceScreenFitting {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 6;
        String[] sentence = new String[]{"a", "bcd", "e"};
        System.out.println(wordsTyping(sentence, rows, cols));
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = "";
        for (String str : sentence) {
            s += str;
            s += " ";
        }

        int len = s.length();
        int start = 0;

        for (int i = 0; i < rows; i++) {
            start  += cols;
            if (s.charAt(start % len ) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }
}
