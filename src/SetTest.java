import java.util.ArrayList;
import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(2));
        System.out.println(set.add(2));
        System.out.println(set.remove(2));
        System.out.println(set.remove(3));
        ArrayList<Integer> nums = new ArrayList<>();
    }
}
