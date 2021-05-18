package Didi;

public class LC243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) p1 = i;
            if (wordsDict[i].equals(word2)) p2 = i;

            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }

        return res;
    }
}
