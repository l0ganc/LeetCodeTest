package Amazon社招OA;


import java.util.*;

public class MClosetDestinations {
    static class Point{
        List<Integer> list;
        int distance;
        public Point(List<Integer> list, int distance) {
            this.list = list;
            this.distance = distance;
        }
    }


    public static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
        if (allLocations == null || allLocations.size() == 0 || allLocations.size() < numDeliveries) {
            return new ArrayList<>();
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.distance - o2.distance;
            }
        });

        for (int i = 0; i < allLocations.size(); i++) {
            List<Integer> list = allLocations.get(i);
            int distance = list.get(0) * list.get(0) + list.get(1) * list.get(1);
            Point point = new Point(list, distance);
            pq.offer(point);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numDeliveries; i++) {
            res.add(pq.poll().list);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(1, -1));
        System.out.println(ClosestXdestinations(3, list, 2));
    }
}
