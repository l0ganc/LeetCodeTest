package Cohesity;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring T
 * that contains at most k distinct characters.
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 */
public class LC340LongestSubstringWithAtmostKDistinctharacters {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                count++;
            }
            end++;

            if (count > k) {
                char remove = s.charAt(start);
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) {
                    count--;
                }
                start++;
            }

            res = Math.max(end - start, res);
        }
        return res;
    }
}
