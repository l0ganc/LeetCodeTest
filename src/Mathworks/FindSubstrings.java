package Mathworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class FindSubstrings {

    public static void findSubstrings(String s) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
        List<String> res = new ArrayList<>();

        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String word = s.substring(i, j);
                if (startWith(vowels, word) && endWith(consonants, word)) {
                    res.add(s.substring(i, j));
                }
            }
        }

        Collections.sort(res, (a, b) -> a.compareTo(b));
        System.out.println(res.get(0));
        System.out.println(res.get(res.size() - 1));
    }

    public static boolean startWith(String[] vowels, String word) {
        for (String s : vowels) {
            if (word.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean endWith(String[] constants, String word) {
        for (String s : constants) {
            if (word.endsWith(s)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        findSubstrings("abc");
        System.out.println("***********");
        findSubstrings("aab");
    }
}
