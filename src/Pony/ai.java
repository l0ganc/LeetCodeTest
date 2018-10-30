package Pony;
import java.util.ArrayList;
import java.util.List;



// Given an array of sorted non-overlapping intervals, and a new interval, return the merged result
// Inputs:
// {[2,5], [6,8], [10,12]}
// [4,7]
// Output:
// {[2,  8], [10,12]}
// package whatever; // don't place package name!

public class ai {
    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }



    private static List<Interval> getRes(List<Interval> input, Interval second) {
        if (second == null) {
            return input;
        }

        List<Interval> res = new ArrayList<>();

        int index = 0;

        while (index < input.size() && input.get(index).end < second.start) {
            res.add(input.get(index));
            index++;
        }

        while (index < input.size() && input.get(index).start < second.end) {
            second.start = Math.min(input.get(index).start, second.start);
            second.end = Math.max(input.get(index).end, second.end);
            index++;
        }

        res.add(second);

        while (index < input.size()) {
            res.add(input.get(index));
            index++;
        }

        return res;
    }


    public static void main (String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(2, 5));
        input.add(new Interval(6, 8));
        input.add(new Interval(10, 12));
        Interval second = new Interval(4, 7);

        List<Interval> res = getRes(input, second);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).start + "," + res.get(i).end);
        }

    }
}
