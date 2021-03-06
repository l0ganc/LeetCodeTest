package Amazon社招OA;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LingjianPack {
    public static int getRes(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i));
        }

        while (pq.size() != 1) {
            int first = pq.poll();
            int second = pq.poll();
            int temp = first + second;
            res += temp;
            pq.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 4, 6, 12);
        List<Integer> list2 = Arrays.asList(1, 2, 5, 10, 35, 89);
        System.out.println(getRes(list));
        System.out.println(getRes(list2));
    }
}
