package Amazon社招OA;

public class XiuluTi {
    /**
     * 有5个城市[1,2,3,4,5]，其中有一些路[[1,2],[2,3],[3,4],[4,5],[1,5]]，这些路里面有坏掉的路，
     * 修理费用是[[1,2,10],[3,4,15],[1,5,30]]，每个元素[0:1]代表路[2]代表费用。
     * 要求：找到修理费用最少的方案让任意一个城市都与任意一个城市联通。
     *
     * 上面的例子输出25
     *
     * quick union时half path compression 一次操作的时间复杂度是o（logn）。。
     *
     *     1. avail roads里是所有存在（不管有没有坏）的路，需要将坏的路剔除。
     */

    public static void main(String[] args) {
        System.out.println(123);
    }

}
