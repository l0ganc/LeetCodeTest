import java.util.ArrayList;
import java.util.List;

public class MissingWords {

    static List<String> getMissing(String s, String t) {
        String[] sArr = s.split(" ");
        String[] tArr = t.split(" ");
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < sArr.length && j < tArr.length) {
            if (sArr[i].equals(tArr[j])) {
                i++;
                j++;
            } else {
                res.add(sArr[i]);
                i++;
            }
        }

        while (i < sArr.length) {
            res.add(sArr[i]);
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "I love programming";
        String t = "programming";

        List<String> res = getMissing(s, t);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
