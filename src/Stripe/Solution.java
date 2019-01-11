package Stripe;

import java.util.*;

public class Solution {
    public static <T> void assertEqual(T expected, T actual) {
        if (expected == null && actual == null || actual != null && actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
        }
    }

    public static void testMinByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(
                Maps.of("a", 1, "b", 2),
                Maps.of("a", 2)
        );
        List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
        List<Map<String, Integer>> example3 = Arrays.asList(Maps.of());
        List<Map<String, Integer>> example4 = Arrays.asList(
                Maps.of("a", -1),
                Maps.of("b", -1)
        );

        System.out.println("minByKey");
        assertEqual(example1.get(0), minByKey("a", example1));
        assertEqual(example2.get(1), minByKey("a", example2));
        assertEqual(example1.get(1), minByKey("b", example1));
        assertEqual(example3.get(0), minByKey("a", example3));
        assertEqual(example4.get(1), minByKey("b", example4));
    }

    public static void main(String[] args) {
        testMinByKey();
        testFirstByKey();
        testFirstBySortOrder();
    }


    private static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
        /**
        Map<String, Integer> resMap = new HashMap<>();
        if (records == null || records.size() == 0) {
            return resMap;
        }

        int globalValue = Integer.MAX_VALUE;
        for (int i = 0; i < records.size(); i++) {
            Map<String, Integer> itemMap = records.get(i);
            if (itemMap.containsKey(key)) {
                globalValue = Math.min(globalValue, itemMap.get(key));
                if (itemMap.get(key) == globalValue) {
                    resMap = itemMap;
                }
            } else {
                globalValue = Math.min(globalValue, 0);
                if (globalValue == 0) {
                    resMap = itemMap;
                }
            }

        }

        return resMap;
         */

        return firstByKey(key, "asc", records);
    }


    public static void testFirstByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(Maps.of("a", 1));
        List<Map<String, Integer>> example2 = Arrays.asList(
                Maps.of("b", 1),
                Maps.of("b", -2),
                Maps.of("a", 10)
        );
        List<Map<String, Integer>> example3 = Arrays.asList(
                Maps.of(),
                Maps.of("a", 10, "b", -10),
                Maps.of(),
                Maps.of("a", 3, "c", 3)
        );

        System.out.println("firstByKey");
        assertEqual(example1.get(0), firstByKey("a", "asc", example1));
        assertEqual(example2.get(0), firstByKey("a", "asc", example2));  // example2.get(1) ok too
        assertEqual(example2.get(2), firstByKey("a", "desc", example2));
        assertEqual(example2.get(1), firstByKey("b", "asc", example2));
        assertEqual(example2.get(0), firstByKey("b", "desc", example2));
        assertEqual(example3.get(1), firstByKey("a", "desc", example3));
    }

    public static void testFirstBySortOrder() {
        List<Map<String, Integer>> example1 = Arrays.asList(
                Maps.of("a", 5),
                Maps.of("a", 6)
        );

        List<Map<String, Integer>> example2 = Arrays.asList(
                Maps.of("a", -5, "b", 10),
                Maps.of("a", -4, "b", 10)
        );
        List<Map<String, Integer>> example3 = Arrays.asList(
                Maps.of("a", -5, "b", 10),
                Maps.of("a", -4, "b", 10),
                Maps.of("a", -6)
        );

        LinkedHashMap<String, String> sortedOrder1 = new LinkedHashMap<>();
        LinkedHashMap<String, String> sortedOrder2 = new LinkedHashMap<>();
        LinkedHashMap<String, String> sortedOrder3 = new LinkedHashMap<>();

        sortedOrder1.put("a", "desc");
        sortedOrder2.put("b", "asc");
        sortedOrder2.put("a", "desc");
        sortedOrder3.put("a", "asc");
        sortedOrder3.put("b", "asc");

        System.out.println("firstBySortOrderKey");
        assertEqual(example1.get(1), sortFirstByOrder(sortedOrder1, example1));
        assertEqual(example2.get(0), sortFirstByOrder(sortedOrder2, example2));
        assertEqual(example2.get(2), sortFirstByOrder(sortedOrder3, example3));
    }



    private static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records){
        Map<String, Integer> resMap = new HashMap<>();
        if (records == null || records.size() == 0) {
            return resMap;
        }
        /**
        if (direction.equals("asc")) {
            int globalValue = Integer.MAX_VALUE;
            for (int i = 0; i < records.size(); i++) {
                Map<String, Integer> itemMap = records.get(i);
                if (itemMap.containsKey(key)) {
                    globalValue = Math.min(globalValue, itemMap.get(key));
                    if (itemMap.get(key) == globalValue) {
                        resMap = itemMap;
                    }
                } else {
                    globalValue = Math.min(globalValue, 0);
                    if (globalValue == 0) {
                        resMap = itemMap;
                    }
                }
            }
        } else if (direction.equals("desc")) {
            int globalValue = Integer.MIN_VALUE;
            for (int i = 0; i < records.size(); i++) {
                Map<String, Integer> itemMap = records.get(i);
                if (itemMap.containsKey(key)) {
                    globalValue = Math.max(globalValue, itemMap.get(key));
                    if (itemMap.get(key) == globalValue) {
                        resMap = itemMap;
                    }
                } else {
                    globalValue = Math.max(globalValue, 0);
                    if (globalValue == 0) {
                        resMap = itemMap;
                    }
                }
            }
        } else {
            return resMap;
        }
        return resMap;
         */
        RecordComparator cmp = new RecordComparator(key, direction);
        Map<String, Integer> record1 = records.get(0);
        resMap = record1;
        for (int i = 0; i < records.size(); i++) {
            Map<String, Integer> record2 = records.get(i);
            if (cmp.Compare(record1, record2) == -1) {
                resMap = record1;
            } else if (cmp.Compare(record1, record2) == 1) {
                resMap = record2;
            }
            // update record1 to the current target map
            record1 = resMap;
        }
        return resMap;
    }

    public static Map<String, Integer> sortFirstByOrder(LinkedHashMap<String, String> sortedOrder, List<Map<String, Integer>> records){
        for (String key : sortedOrder.keySet()) {
            String direction = sortedOrder.get(key);
            Collections.sort(records, new Comparator<Map<String, Integer>>() {
                @Override
                public int compare(Map<String, Integer> record1, Map<String, Integer> record2) {
                    RecordComparator cmp = new RecordComparator(key, direction);
                    if (cmp.Compare(record1, record2) == 0) {
                        if (direction.equals("asc")) {
                            return record1.get(key) - record2.get(key);
                        } else if (direction.equals("desc")) {
                            return record2.get(key) - record1.get(key);
                        }
                    }
                    return 0;
                }
            });
        }
        return records.get(0);
    }


}


class Maps {
    public static <K, V> Map<K, V> of() {
        return new HashMap<K, V>();
    }

    public static <K, V> Map<K, V> of(K k1, V v1) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2, K k3, V v3) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }
}

class RecordComparator {
    String key;
    String direction;

    public RecordComparator(String key, String direction) {
        this.key = key;
        this.direction = direction;
    }

    public int Compare(Map<String, Integer> record1, Map<String, Integer> record2) {
        int value1 = 0;
        int value2 = 0;
        if (record1.containsKey(key)) {
            value1 = record1.get(key);
        }
        if (record2.containsKey(key)) {
            value2 = record2.get(key);
        }

        if (direction.equals("asc")) {
            if (value1 < value2) {
                return -1;
            } else if (value1 == value2) {
                return 0;
            } else {
                return 1;
            }
        } else if (direction.equals("desc")) {
            if (value1 < value2) {
                return 1;
            } else if (value1 == value2) {
                return 0;
            } else {
                return -1;
            }
        }
        return -2;
    }
}