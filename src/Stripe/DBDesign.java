package Stripe;

import java.util.*;

public class DBDesign {
    public static void main(String[] args) {
        String key1 = "a";
        String key2 = "b";
        Map<String, Integer> record1 = new HashMap<>();
        record1.put("a", 1);
        record1.put("b", 2);

        Map<String, Integer> record2 = new HashMap<>();
        record2.put("a", 2);

        Map<String, Integer> record3 = new HashMap<>();
        record3.put("a", -1);

        Map<String, Integer> record4 = new HashMap<>();
        record4.put("b", -1);


        Map<String, Integer> record5 = new HashMap<>();
        record5.put("a", 1);

        Map<String, Integer> record6 = new HashMap<>();
        record6.put("b", 1);
        record6.put("b", -2);



        List<Map<String, Integer>> records1 = Arrays.asList(record1, record2);
        List<Map<String, Integer>> records2 = Arrays.asList(record2, record1);
        List<Map<String, Integer>> records5 = Arrays.asList(record3, record4);

        /**
        Map<String, Integer> resMap1 = minByKey(key1, records1);
        for (String s : resMap1.keySet()) {
            System.out.println(s + " : " + resMap1.get(s));
        }

        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap2 = minByKey(key1, records2);
        for (String s : resMap2.keySet()) {
            System.out.println(s + " : " + resMap2.get(s));
        }



        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap3 = minByKey(key2, records1);
        for (String s : resMap3.keySet()) {
            System.out.println(s + " : " + resMap3.get(s));
        }


        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap4 = minByKey(key1, new ArrayList<>());
        for (String s : resMap4.keySet()) {
            System.out.println(s + " : " + resMap4.get(s));
        }

        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap5 = minByKey(key2, records5);
        for (String s : resMap5.keySet()) {
            System.out.println(s + " : " + resMap5.get(s));
        }
         */


        Map<String, Integer> resMap1 = firstByKey(key1, "asc", records1);
        for (String s : resMap1.keySet()) {
            System.out.println(s + " : " + resMap1.get(s));
        }

        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap2 = minByKey(key1, records2);
        for (String s : resMap2.keySet()) {
            System.out.println(s + " : " + resMap2.get(s));
        }



        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap3 = minByKey(key2, records1);
        for (String s : resMap3.keySet()) {
            System.out.println(s + " : " + resMap3.get(s));
        }


        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap4 = minByKey(key1, new ArrayList<>());
        for (String s : resMap4.keySet()) {
            System.out.println(s + " : " + resMap4.get(s));
        }

        System.out.println("==================================");
        System.out.println("==================================");
        Map<String, Integer> resMap5 = minByKey(key2, records5);
        for (String s : resMap5.keySet()) {
            System.out.println(s + " : " + resMap5.get(s));
        }







    }

    private static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
        Map<String, Integer> resMap = new HashMap<>();
        if (records == null || records.size() == 0) {
            return resMap;
        }

        int globalValue = Integer.MAX_VALUE;
        for (int i = 0; i < records.size(); i++) {
            Map<String, Integer> itemMap = records.get(i);
            if (itemMap.containsKey(key)) {
                globalValue = Math.min(globalValue, itemMap.get(key));
            } else {
                globalValue = Math.min(globalValue, 0);
            }
        }

        for (int i = 0; i < records.size(); i++) {
            Map<String, Integer> itemMap = records.get(i);
            if (itemMap.containsKey(key)) {
                if (itemMap.get(key) == globalValue) {
                    return itemMap;
                }
            } else if (!itemMap.containsKey(key) && globalValue == 0) {
                return itemMap;
            }
        }
        return resMap;
    }


    private static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
        Map<String, Integer> resMap = new HashMap<>();
        if (records == null || records.size() == 0) {
            return resMap;
        }

        if (direction.equals("asc")) {
            int globalValue = Integer.MAX_VALUE;
            for (int i = 0; i < records.size(); i++) {
                Map<String, Integer> itemMap = records.get(i);
                if (itemMap.containsKey(key)) {
                    globalValue = Math.min(globalValue, itemMap.get(key));
                } else {
                    globalValue = Math.min(globalValue, 0);
                }
            }

            for (int i = 0; i < records.size(); i++) {
                Map<String, Integer> itemMap = records.get(i);
                if (itemMap.containsKey(key)) {
                    if (itemMap.get(key) == globalValue) {
                        return itemMap;
                    }
                } else if (!itemMap.containsKey(key) && globalValue == 0) {
                    return itemMap;
                }
            }
        } else if (direction.equals("desc")) {
            int globalValue = Integer.MIN_VALUE;
            for (int i = 0; i < records.size(); i++) {
                Map<String, Integer> itemMap = records.get(i);
                if (itemMap.containsKey(key)) {
                    globalValue = Math.max(globalValue, itemMap.get(key));
                } else {
                    globalValue = Math.max(globalValue, 0);
                }
            }

            for (int i = 0; i < records.size(); i++) {
                Map<String, Integer> itemMap = records.get(i);
                if (itemMap.containsKey(key)) {
                    if (itemMap.get(key) == globalValue) {
                        return itemMap;
                    }
                } else if (!itemMap.containsKey(key) && globalValue == 0) {
                    return itemMap;
                }
            }
        }
        return resMap;
    }

}
