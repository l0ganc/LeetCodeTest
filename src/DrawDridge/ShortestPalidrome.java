package DrawDridge;

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 * Before we go further, let us understand with few examples:
 *
 * ab: Number of insertions required is 1 i.e. bab
 * aa: Number of insertions required is 0 i.e. aa
 * abcd: Number of insertions required is 3 i.e. dcbabcd
 * abcda: Number of insertions required is 2 i.e. adcbcda which is same as number of insertions in the substring bcd(Why?).
 * abcde: Number of insertions required is 4 i.e. edcbabcde
 *
 * 可以用recursive 也可以用DP
 *
 * Let the input string be str[l……h]. The problem can be broken down into three parts:
 * 1. Find the minimum number of insertions in the substring str[l+1,…….h].
 * 2. Find the minimum number of insertions in the substring str[l…….h-1].
 * 3. Find the minimum number of insertions in the substring str[l+1……h-1].
 *
 * Recursive Solution
 * The minimum number of insertions in the string str[l…..h] can be given as:
 *
 * minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
 * min(minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])) + 1 otherwise
 */
public class ShortestPalidrome {
    public static void main(String[] args) {
        String s = "abcde";
        String s1 = "geeks";
        System.out.println(getshortestPalindrome(s.toCharArray(), 0, s.length() - 1));
        System.out.println(getshortestPalindrome(s1.toCharArray(), 0, s.length() - 1));

        // dp solution
        System.out.println(findMinInsertionsDP(s.toCharArray(), s.length()));
        System.out.println(findMinInsertionsDP(s1.toCharArray(), s1.length()));
    }

    private static int getshortestPalindrome(char[] str, int l, int h) {
        if (l > h) return Integer.MAX_VALUE;
        if (l == h) return 0;
        if (l == h - 1) return (str[l] == str[h] ? 0 : 1);

        if (str[l] == str[h]) {
            return getshortestPalindrome(str, l + 1, h - 1);
        } else {
            return 1 + Math.min(getshortestPalindrome(str, l + 1, h), getshortestPalindrome(str, l, h - 1));
        }
    }


    // dp solution ,use table to reuse the result
    public static int findMinInsertionsDP(char str[], int n)
    {
        // Create a table of size n*n. table[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h])?
                        table[l+1][h-1] :
                        (Integer.min(table[l][h-1],
                                table[l+1][h]) + 1);

        // Return minimum number of insertions
        // for str[0..n-1]
        return table[0][n-1];
    }
}
