import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class StringSearch {
    public static void main(String[] args) {
        String[] wordlist = new String[]{"KiTe","kite","hare","Hare"};
        String[] queries1 = new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        String[] queries = new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        String s = "aoie";

        String[] res = spellchecker(wordlist, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + ", ");
        }
        System.out.println();
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        String[] res = new String[queries.length];
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> capMap = new HashMap<>();
        HashMap<String, String> vowMap = new HashMap<>();

        for (String s : wordlist) {
            set.add(s);
            String lower = s.toLowerCase();
            if (!capMap.containsKey(lower)) {
                capMap.put(lower, s);
            }
            if (!vowMap.containsKey(vowel(lower))) {
                vowMap.put(vowel(lower), s);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) {
                res[i] = queries[i];
                continue;
            }
            String lower = queries[i].toLowerCase();
            if (capMap.containsKey(lower)) {
                res[i] = capMap.get(lower);
            } else if (vowMap.containsKey(vowel(lower))) {
                res[i] = vowMap.get(vowel(lower));
            } else {
                res[i] = "";
            }
        }
        return res;

    }

    /**
    private static String vowel(String s) {
        char[] temp = s.toCharArray();
        for (char c : temp) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                c = '*';
            }
        }
        return new String(temp);
    }
     */

    private static String vowel(String s) {
        char[] temp = s.toLowerCase().toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
                temp[i] = '*';
            }
        }
        return new String(temp);
    }
}