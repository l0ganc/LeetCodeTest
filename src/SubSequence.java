import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequence {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> curSeq = Arrays.asList(1, 2, 3);
        List<Integer> gg = new ArrayList<>(Arrays.asList(6, 7, 8));
        res.add(curSeq);
        test.add(new ArrayList<>(curSeq));
        test.add(0, gg);
        System.out.println(res);
        System.out.println(test);

        test.remove(test.size() - 1);
        System.out.println(test);
    }
}
