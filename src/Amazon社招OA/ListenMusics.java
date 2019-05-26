package Amazon社招OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListenMusics {
    static class Pair{
        int index;
        int duration;
        public Pair(int index, int duration) {
            this.index = index;
            this.duration = duration;
        }
    }

    public static List<Integer> IDsOfSongs(int rideDuration, List<Integer> songDurations) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < songDurations.size(); i++) {
            list.add(new Pair(i, songDurations.get(i)));
        }
        Collections.sort(list, (a, b) -> a.duration - b.duration);
        int i = 0;
        int j = songDurations.size() - 1;

        List<Integer> res = new ArrayList<>();
        while (i < j) {
            int sum = list.get(i).duration + list.get(j).duration;
            if (sum == rideDuration - 30) {
                res.add(i);
                res.add(j);
                return res;
            } else if (sum > rideDuration - 30) {
                j--;
            } else {
                i++;
            }
        }
        return Arrays.asList(-1, -1);
    }

    public static void main(String[] args) {
        List<Integer> songDurations = Arrays.asList(1, 2, 29, 30);
        List<Integer> songDurations2 = Arrays.asList(1);
        int rideDuration = 61;
        System.out.println(IDsOfSongs(rideDuration, songDurations));
        System.out.println(IDsOfSongs(0, songDurations));
        System.out.println(IDsOfSongs(rideDuration, songDurations2));
    }
}
