import java.util.ArrayList;
import java.util.List;

public class LC1002FindCommonCharacter {
    public static void main(String[] args) {
        String[] A = new String[]{"cool","lock","cook"};
        List<String> res = commonChars(A);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }

        List<char[]> list = new ArrayList<>();
        for (int i = 1; i < A.length; i++) {
            list.add(A[i].toCharArray());
        }
        for (char c : A[0].toCharArray()) {
            int i = 0;
            for (; i < list.size(); i++) {
                char[] temp = list.get(i);
                if (String.valueOf(temp).contains(String.valueOf(c))) {
                    for (int j = 0; j < temp.length; j++) {
                        if (temp[j] == c) {
                            temp[j] = '*';
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (i == list.size()) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}
