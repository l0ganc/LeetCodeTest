import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC973 {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1, 3}, {-2, 2}
        };
        int K = 1;
        int[][] res = kClosest(points, K);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }

        System.out.println(-1 % 5);
    }

    public static  int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[points.length][2];
        int[] temp = new int[points.length];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            map.put(temp[i], new int[]{points[i][0], points[i][1]});
        }
        Arrays.sort(temp);
        for (int i = 0; i < K; i++) {
            res[i][0] = map.get(temp[i])[0];
            res[i][1] = map.get(temp[i])[1];
        }
        return res;
    }
}
