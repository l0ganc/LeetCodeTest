public class CharCompareTest {
    private static String vowel(String s) {
        char[] temp = s.toCharArray();
        for (char c : temp) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                c = '*';
            }
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        String s = "KiTe";
        System.out.println(vowel(s));
    }

}


