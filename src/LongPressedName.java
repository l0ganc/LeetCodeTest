import java.util.HashMap;

public class LongPressedName {
    static boolean isLongPressedName(String name, String typed) {
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for (char c : name.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        for (char c : typed.toCharArray()) {
            mapA.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        for (Character c : mapA.keySet()) {
            if (!mapB.containsKey(c)) {
                return false;
            }
            if (mapB.get(c) < mapA.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        System.out.println(isLongPressedName(name, typed));
    }
}
