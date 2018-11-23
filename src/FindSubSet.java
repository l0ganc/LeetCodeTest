import java.util.ArrayList;
import java.util.List;

public class FindSubSet {
    public static void main(String[] args) {
        String input = "abcdef";
        List<String> res  = getRes(input);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static List<String> getRes(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }

        DFS(input, 0, res, new StringBuilder());
        return res;
    }

    private static void DFS(String input, int index, List<String> res, StringBuilder sb) {
        res.add(sb.toString());

        for (int i = index; i < input.length(); i++) {
            sb.append(input.charAt(i));
            DFS(input, i + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
