package Clutter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeforeAndAfterPuzzle {
    public static List<String> generate_phrases(List<String> phrases) {
        List<String> res = new ArrayList<>();
        if (phrases == null || phrases.size() == 0) {
            return res;
        }

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < phrases.size(); i++) {
            String[] splitArr = phrases.get(i).split(" ");
            String first = splitArr[0];
            if (!map.containsKey(first)) {
                map.put(first, new ArrayList<>());
            }
            map.get(first).add(i);
        }

        for (int i = 0; i < phrases.size(); i++) {
            String[] arr = phrases.get(i).split(" ");
            String last = arr[arr.length - 1];
            if (map.containsKey(last)) {
                List<Integer> list = map.get(last);
                for (int k = 0; k < list.size(); k++) {
                    int index = phrases.get(i).lastIndexOf(' ');
                    res.add(phrases.get(i).substring(0, index + 1) + phrases.get(list.get(k)));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("mission statement");
        input.add("a quick bite to eat");
        input.add("a chip off the old block");
        input.add("chocolate bar");
        input.add("mission impossible");
        input.add("a man on a mission");
        input.add("block party");
        input.add("eat my words");
        input.add("bar of soap");

        List<String> input0 = new ArrayList<>();
        input0.add("writing code");
        input0.add("code rocks");

        System.out.println(generate_phrases(input0));
        System.out.println();
        System.out.println(generate_phrases(input));
    }
}
