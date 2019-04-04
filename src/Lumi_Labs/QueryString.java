package Lumi_Labs;

import java.util.HashMap;
import java.util.Map;

public class QueryString {
    // 两个string，query跟target，query相当于target的的subquence，target包含query就 return true。
    // 其实就是LC392 Is Subsequence
    public static boolean canFound(String query, String target) {
        if (query == null || target == null) return true;
        int i = 0;
        int j = 0;

        while (i < query.length() && j < target.length()) {
            if (query.charAt(i) == target.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == query.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFound("adg", "abcdefg"));
        System.out.println(canFound("agd", "abcdefg"));
        System.out.println(canFound("axc", "ahbgdc"));
    }
}
