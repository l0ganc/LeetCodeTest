package Amazon社招OA;

import java.util.*;

public class ZeroOneMaze {



    public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        int[][] map = new int[numRows][numColumns];
        boolean[][] visit = new boolean[numRows][numColumns];
        for (int i = 0; i < lot.size(); i++) {
            //List<Integer> sub = lot.get(i);
            for (int j = 0; j < lot.get(i).size(); j++) {
                map[i][j] = lot.get(i).get(j);
            }
        }

        int res = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x < 0 || x >= numRows || y < 0 || y >= numColumns || map[x][y] == 0 || visit[x][y]) {
                    continue;
                }
                visit[x][y] = true;
                if (map[x][y] == 9) {
                    return res;
                }

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    queue.offer(new int[]{nextX, nextY});
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> lot = new ArrayList<>();
        lot.add(Arrays.asList(1, 0, 0));
        lot.add(Arrays.asList(1, 0, 0));
        lot.add(Arrays.asList(1, 9, 1));
        System.out.println(removeObstacle(3, 3, lot));
    }
}
