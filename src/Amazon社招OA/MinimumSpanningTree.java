package Amazon社招OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    static class Connection {
        int city1;
        int city2;
        int cost;
        public Connection(int city1, int city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    static class UnionFind{
        private int[] ids;

        public UnionFind(int size) {
            this.ids = new int[size + 1];
            for (int i = 0; i < size + 1; i++) {
                this.ids[i] = i;
            }
        }

        public int root(int i) {
            while (ids[i] != i) {
                i = ids[i];
            }
            return i;
        }

        public boolean find(int i, int j) {
            return root(i) == root(j);
        }

        public void union(int i, int j) {
            int rooti = root(i);
            int rootj = root(j);
            ids[rooti] = rootj;
        }
    }

    public static int GetMinimumCostToConstruct(int numTotalAvailableCities,
                                                int numTotalAvailableRoads,
                                                List<List<Integer>> roadsAvailable,
                                                int numNewRoadsConstruct,
                                                List<List<Integer>> costNewRoadsConstruct) {

        // already connected
        if (numTotalAvailableCities < 2 || numTotalAvailableRoads >= numTotalAvailableCities - 1) {
            return 0;
        }

        UnionFind uf = new UnionFind(numTotalAvailableCities);
        int exsitingRoads = 0;

        // calculate the number of roads already in connected
        for (List<Integer> pair : roadsAvailable) {
            int city1 = pair.get(0);
            int city2 = pair.get(1);
            if (!uf.find(city1, city2)) {
                uf.union(city1, city2);
                exsitingRoads++;
            }
        }

        // add all the roads connection into priorityqueue
        PriorityQueue<Connection> pq = new PriorityQueue<>(numNewRoadsConstruct, (a, b) -> a.cost - b.cost);

        for (List<Integer> newRoad : costNewRoadsConstruct) {
            Connection connection = new Connection(newRoad.get(0), newRoad.get(1), newRoad.get(2));
            pq.add(connection);
        }

        List<Connection> mst = new ArrayList<>();

        while (pq.size() > 0 && mst.size() + exsitingRoads < numTotalAvailableCities - 1) {
            Connection temp = pq.poll();
            int city1 = temp.city1;
            int city2 = temp.city2;
            if (!uf.find(city1, city2)) {
                uf.union(city1, city2);
                mst.add(temp);
            }
        }

        if (mst.size() + exsitingRoads < numTotalAvailableCities - 1) {
            return -1;
        }

        int res = 0;
        for (Connection cn : mst) {
            res += cn.cost;
        }

        return res;
    }

    public static void main(String[] args) {
        int numTotalAvailableCities = 6;
        int numTotalAvailableRoads = 3;
        List<List<Integer>> roadsAvailable = new ArrayList<>();
        roadsAvailable.add(Arrays.asList(1, 4));
        roadsAvailable.add(Arrays.asList(4, 5));
        roadsAvailable.add(Arrays.asList(2, 3));
        int numNewRoadsConstruct = 4;
        List<List<Integer>> costNewRoadsConstruct = new ArrayList<>();
        costNewRoadsConstruct.add(Arrays.asList(1, 2, 5));
        costNewRoadsConstruct.add(Arrays.asList(1, 3, 10));
        costNewRoadsConstruct.add(Arrays.asList(1, 6, 2));
        costNewRoadsConstruct.add(Arrays.asList(5, 6, 5));

        System.out.println(GetMinimumCostToConstruct(numTotalAvailableCities,
                numTotalAvailableRoads, roadsAvailable, numNewRoadsConstruct, costNewRoadsConstruct));
    }
}
