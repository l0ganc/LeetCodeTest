import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationNumber {

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, n, k, new ArrayList<>(), 1);
        return res;
    }

    private static void helper(List<List<Integer>> res, int n, int k, List<Integer> cur, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(res, n, k - 1, cur, i + 1);
            cur.remove(cur.size() - 1);
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
