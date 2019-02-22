package Mathworks;

import java.util.HashMap;
import java.util.Map;

/**
 * Sample Input 1 String[] votes = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
 *
 * Sample Output 1 Michael
 *
 * Explanation 1  Alex, Harry, Michael, and Mary are all tied for the highest number of votes.
 * Because Michael is alphabetically last, we return his name as the winner.
 */
public class Election {
    public static void main(String[] args) {
        String[] votes = new String[]{"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
        String[] votes2 = new String[]{"Victor", "Veronica", "Ryan", "Dave", "Maria", "Maria", "Farah", "Farah", "Ryan", "Veronica"};
        //System.out.println(getWinnerName(votes));
        System.out.println(getWinnerName(votes2));

    }

    public static String getWinnerName(String[] votes) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : votes) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        int max = 0;
        for (String name : map.keySet()) {
            max = Math.max(max, map.get(name));
        }

        String res = "";
        for (String name : map.keySet()) {
            if (map.get(name) == max) {
                if (res.compareTo(name) < 0) {
                    res = name;
                }
            }
        }
        return res;
    }
}
