import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DebugLC210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prere = new int[][]{
                {1,0}, {2,0}, {3,1}, {3,2}
        };
        System.out.println(Arrays.toString(findOrder(numCourses, prere)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] results = new int[numCourses];
        if (numCourses <= 0 || prerequisites == null) {
            return results;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            if (graph.containsKey(pair[1])) {
                graph.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(pair[0]);
                graph.put(pair[1], newList);
            }
        }

        int first = 0, last = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                results[last++] = i;
            }
        }

        while (first < last) {
            List<Integer> subCourses = graph.get(results[first]);
            if (subCourses != null) {
                for (int sub : subCourses) {
                    if (--inDegree[sub] == 0) {
                        results[last++] = sub;
                    }
                }
            }
            first++;
        }

        if (last != numCourses) {
            return new int[0];
        }
        return results;
    }
}
