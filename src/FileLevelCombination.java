import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLevelCombination {
    private static List<String> combine(int n, int k) {
        List<String> res = new ArrayList<>();
        helper(res, n, k, "", 1);
        return res;
    }

    private static void helper(List<String> res, int n, int k, String cur, int start) {
        if (k == 0) {
            res.add(cur);
            return;
        }

        for (int i = 1; i <= n; i++) {
            cur += "/" + i;
            helper(res, n, k - 1, cur, i + 1);
            cur = cur.substring(0, cur.length() - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入n : ");
        int n = sc.nextInt();
        System.out.print("请输入k : ");
        int k = sc.nextInt();
        System.out.println(combine(n, k));
    }

}
