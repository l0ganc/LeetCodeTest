package Quantcast;

import java.util.*;

/**
 * 一亩三分地
 * 请仔细认真诚挚得对待OA，据我所知通过率非常低。尤其注意style。i.e. comments, input check, etc.
 */
public class DisjointSet {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1,2");
        input.add("4,3");
        input.add("2,3");
        input.add("6,7");
        input.add("4,5");
        input.add("5,6");
        input.add("8,9");
        input.add("9,10");
        input.add("10,13");
        input.add("19,22");
        input.add("3,34");
        input.add("35,34");
        input.add("35,36");
        input.add("36,37");


        List<List<String>> res = getResult(input);
        for (int i = 0; i < res.size(); i++) {
            List<String> temp = res.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + ", ");
            }
            System.out.println();
        }
    }


    public static List<List<String>> getResult(List<String> input) {
        List<List<String>> res = new ArrayList<>();  // result list
        if (input == null || input.size() == 0) {   // base case
            return res;
        }
        Collections.sort(input, new Comparator<String>() {   // sort the given input first
            @Override
            public int compare(String o1, String o2) {
                String[] first = o1.split(",");
                String[] second = o2.split(",");
                return Integer.parseInt(first[0]) - Integer.parseInt(second[0]);
            }
        });
        HashSet<String> set = new HashSet<>();  // use set to rule out duplicate one
        List<String> list = new ArrayList<>();  // list is the one we need to add it into res finally
        String first = input.get(0);    // get first object
        String[] firstArr = first.split(",");   // split it  by ','
        set.add(firstArr[0]);       // add firstArr
        set.add(firstArr[1]);
        list.add(first);

        int i = 1;   // i is used to traverse from 1 because we have handle the first onject
        while (i < input.size()) {
            String second = input.get(i);
            String[] secondArr = second.split(",");   // handle the next object
            if (set.contains(secondArr[0]) || set.contains(secondArr[1])) {  // if there is a match, means we can merge second object
                set.add(secondArr[0]);
                set.add(secondArr[1]);   // update set
                list.add(second);        // update list
                if (i == input.size() - 1) {  // if reaching the end, add the list into res
                    res.add(list);
                }
            } else {   // is there isn't match, we need to create another list
                List<String> temp = new ArrayList<>();
                temp.addAll(list);   // store the list value first
                res.add(temp);     // because the temp list cannot merge other object, we can safely add it into res
                List<String> newList = new ArrayList<>();  // new list
                newList.add(second);  // update new list
                set.clear();  // empty set and re-use it
                list.clear(); // clear list and re-use it
                list.addAll(newList);   // update list
                set.add(secondArr[0]);
                set.add(secondArr[1]);   // update set
                if (i == input.size() - 1) {    // if reaching the end, add the current list into final res
                    res.add(list);
                }
            }
            i++;   // i increment by 1
        }
        return res;
    }


//    public static List<List<String>> getResUnionFind(List<String> input) {
//        HashMap<Integer, String> map = new HashMap<>();
//        for (int i = 0; i < input.size(); i++) {
//            map.put(i, input.get(i));
//        }
//    }

}
