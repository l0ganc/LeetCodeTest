package Amazon社招OA;

import java.util.*;

public class LC973KClosestPointsToOrigin {

    // time = O(NlogK)

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "The rain in Spain falls mainly in the plain.";
        System.out.println((s.split(" ", 2))[1]);

        List<Integer> re = new ArrayList<>();

        re.add(1);
        re.add(2);
        re.add(6);
        re.add(5);
        re.add(8);
        re.add(8);
        re.add(4);

        Collections.sort(re, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                //下面这么写，结果是降序
                if(o1 < o2){
                    return -1;
                }else if(o1 > o2){
                    return 1;
                }
                return 0;
            }

        });

        System.out.println(re);
    }
}
