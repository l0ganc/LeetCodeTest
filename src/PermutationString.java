import java.util.ArrayList;
import java.util.List;

public class PermutationString {
    public static void main(String[] args) {
        String str = "abc";
        List<String> res = new ArrayList<>();

        permute(str, 0, res);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static void permute(String input, int index, List<String> res) {
        if (index == input.length()) {
            res.add(input);
            return;
        }

        for (int i = index; i < input.length(); i++) {
            input = swap(input, index, i);
            permute(input, index + 1, res);
            input = swap(input, index, i);
        }
    }

    private static String swap(String str, int i, int j) {
        char[] temp = str.toCharArray();
        char t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;

        return String.valueOf(temp);
    }
}
