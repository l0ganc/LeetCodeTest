package DrawDridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalMaximum {
    public static int result = 0;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7));
        int m = 3;
        System.out.println("The global maximum is : " + getGlobalMaximum(list, m));


    }

    private static int getGlobalMaximum(List<Integer> list, int m) {
        List<List<Integer>> res = new ArrayList<>();
        helper(m, list, 0, new ArrayList<>());
        return result;
    }

    private static void helper(int m, List<Integer> input, int start, List<Integer> list) {
        if (list.size() == m) {
            result = Math.max(result, getMinDifference(list));
            return;
        }

        for (int i = start; i < input.size(); i++) {
            list.add(input.get(i));
            helper(m, input, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private static int getMinDifference(List<Integer> input) {
        if (input.size() == 1) {
            return 0;
        }

        int i = 0, j = 1, res = Integer.MAX_VALUE;
        while (j < input.size()) {
            res = Math.min(res, input.get(j) - input.get(i));
            i++;
            j++;
        }
        return res;
    }
}
