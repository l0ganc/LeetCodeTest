package Amazon_OA2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 卡车运东西，选做多能运的两件货物
 */
public class TruckGoods {
    static class Pair{
        double first;
        double second;
        public Pair(Double first, Double second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        int numContianters = 6;
        double maxCap = 43.3;
        double[] containersWt = new double[] {
                7.33, 8.13, 103.7313, 11.24, 23.79, 18.3501
        };

        Pair res = getRes(numContianters, maxCap, containersWt);
        System.out.println(res.first);
        System.out.println(res.second);

    }

    public static Pair getRes(int numContianters, double maxCap, double[] containersWt) {
        Arrays.sort(containersWt);
        int i = 0;
        int j = containersWt.length - 1;

        while (i + 1 < j) {
            if (containersWt[i] + containersWt[j] > maxCap) {
                j--;
            } else if (containersWt[i] + containersWt[j] < maxCap) {
                i++;
            }
        }

        return new Pair(containersWt[i], containersWt[j]);
    }
}
