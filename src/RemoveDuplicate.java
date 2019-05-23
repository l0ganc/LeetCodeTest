public class RemoveDuplicate {
    public static String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        if (S.length() == 1) return S;
        if (S.length() == 2) return S.charAt(0) == S.charAt(1) ? "" : S;

        int i = 0;
        int j = 1;

        while (j < S.length()) {
            if (S.charAt(i) == S.charAt(j)) {
                i = j + 1;
                j = i + 1;
            } else {
                if (j + 1 < S.length() && S.charAt(j) == S.charAt(j + 1)) {
                    j += 2;
                }
                if (j == S.length() - 1) break;
                j++;
                i++;

            }
        }
        return S.substring(0, i + 1) + S.substring(j);
    }

    public static void main(String[] args) {
        //System.out.println(removeDuplicates("azxxzy"));

        String q = "abcf";
        String p = "abc";
        System.out.println(p.indexOf('a'));
        System.out.println(p.indexOf('b'));
        System.out.println(p.indexOf('c'));
        System.out.println(p.indexOf('u'));
    }
}
