import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FirstBlood {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int bound = 100;
        List<Integer> res = powerfulIntegers(x, y, bound);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int m = getBound(x, bound);
        int n = getBound(y, bound);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = (int)(Math.pow(x, i) + Math.pow(y, j));
                if (temp <= bound) {
                    set.add(temp);
                }
            }
        }

        List<Integer> res = new ArrayList<>(set);

        return res;

    }

    private static int getBound(int x, int bound) {
        if (x == 1) {
            return 1;
        }
        for (int i = 0; i <= bound; i++) {
            if (Math.pow(x, i) > bound) {
                return i;
            }
        }
        return 0;
    }
}
