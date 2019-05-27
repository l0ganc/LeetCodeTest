package Amazon社招OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class WurenjiSonghuo {
    public static List<List<Integer>> PrimeMaxProfit(int maxTravelDist,
                                                     List<List<Integer>> forwardRouteList,
                                                     List<List<Integer>> returnRouteList) {
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        int mostClosest = Integer.MIN_VALUE;

        for (int i = 0; i < forwardRouteList.size(); i++) {
            for (int j = 0; j < returnRouteList.size(); j++) {
                int forId = forwardRouteList.get(i).get(0);
                int forDist = forwardRouteList.get(i).get(1);

                int retId = returnRouteList.get(j).get(0);
                int retDist = returnRouteList.get(j).get(1);

                int sum = forDist + retDist;
                if (sum > maxTravelDist) continue;

                mostClosest = Math.max(mostClosest, sum);
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(Arrays.asList(forId, retId));
            }
        }

        return map.get(mostClosest);
    }

    public static void main(String[] args) {
        int maxTravelDist = 7000;
        List<List<Integer>> forward = new ArrayList<>();
        forward.add(Arrays.asList(1, 2000));
        forward.add(Arrays.asList(2, 4000));
        forward.add(Arrays.asList(3, 6000));

        List<List<Integer>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(1, 2000));

        int maxTravelDist1 = 10000;
        List<List<Integer>> forward1 = new ArrayList<>();
        forward1.add(Arrays.asList(1, 3000));
        forward1.add(Arrays.asList(2, 5000));
        forward1.add(Arrays.asList(3, 7000));
        forward1.add(Arrays.asList(4, 10000));

        List<List<Integer>> returnList1 = new ArrayList<>();
        returnList1.add(Arrays.asList(1, 2000));
        returnList1.add(Arrays.asList(2, 3000));
        returnList1.add(Arrays.asList(3, 4000));
        returnList1.add(Arrays.asList(4, 5000));

        System.out.println(PrimeMaxProfit(maxTravelDist, forward, returnList));
        System.out.println(PrimeMaxProfit(maxTravelDist1, forward1, returnList1));
    }
}
