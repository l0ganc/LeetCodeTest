package Stripe;

import java.util.*;

public class ServerName {
    static HashMap<String, LinkedHashSet<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(allocate("a"));
        System.out.println(allocate("a"));
        System.out.println(allocate("c"));
        System.out.println(deallocate("a2"));
        System.out.println(allocate("a"));

    }
    private static String allocate(String serverName) {
        if (!map.containsKey(serverName)) {
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            set.add(1);
            map.put(serverName, set);
        } else {
            int size = map.get(serverName).size();
            map.get(serverName).add(size + 1);
        }
        int size = map.get(serverName).size();
        return serverName + String.valueOf(size);
    }

    private static int deallocate(String serverName) {
        int numIndex = 0;
        for (int i = 0; i < serverName.length(); i++) {
            if (Character.isDigit(serverName.charAt(i))) {
                numIndex = i;
                break;
            }
        }

        String key = serverName.substring(0, numIndex);
        if (!map.containsKey(key)) {
            return -1;
        }

        LinkedHashSet<Integer> set = map.get(key);
        if (set.size() == 0) {
            map.remove(serverName);
        } else {
            set.remove(set.size());
            map.put(key, set);
        }
        return Integer.parseInt(serverName.substring(numIndex));
    }
}
