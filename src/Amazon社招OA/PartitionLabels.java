package Amazon社招OA;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    /**
     * A string S of lowercase letters is given. We want to partition this string into as many parts as possible
     * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     */

    /**
     * traverse the string record the last index of each char.
     * using pointer to record end of the current sub string.
     *
     * time = O(n)
     * space = O(n)
     */

    public static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
