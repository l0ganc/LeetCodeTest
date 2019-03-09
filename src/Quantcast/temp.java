package Quantcast;

public class temp {
    public static List<List<Node>> getDisjointSets(List<Node> nodes) {
        List<List<Node>> res = new ArrayList<>(); // result list
        if (nodes == null || nodes.size() == 0) { // base case check
            return res;
        }
        Set<Node> removeDupSet = new HashSet<>();  // use set to remove duplicate node in nodes
        for (int i = 0; i < nodes.size(); i++) {
            removeDupSet.add(nodes.get(i));
        }
        nodes.clear();
        nodes = new ArrayList<>(removeDupSet);   // update given nodes with removeDupSet

        Collections.sort(nodes, new Comparator<Node>() {  // sort the nodes according to id1
            @Override
            public int compare(Node n1, Node n2) {
                return n1.id1 - n2.id1;
            }
        });

        HashSet<Integer> set = new HashSet<>();   // use set to judge if two nodes sharing an id
        List<Node> cur = new ArrayList<>();       // use cur list to store the current nodes which can be one group
        // handle the first node
        Node first = nodes.get(0);
        set.add(first.id1);  // update intital set
        set.add(first.id2);
        cur.add(first);     // update intital cur

        int i = 1;   // use i to traverse the nodes list
        while (i < nodes.size()) {
            Node second = nodes.get(i);   // get the next one node
            if (set.contains(second.id1) || set.contains(second.id2)) {   // if sharing id with first node
                set.add(second.id1);    // update set and cur
                set.add(second.id2);
                cur.add(second);
                if (i == nodes.size() - 1) {   // if reaching the end, safely add cur list into our res list
                    res.add(cur);
                }
            } else {   // if not sharing, we need create a new list
                List<Node> temp = new ArrayList<>();
                temp.addAll(cur);   // temp list has the same node values as cur
                res.add(temp);      // add temp list into our result
                List<Node> newList = new ArrayList<>();   // creat a new list
                newList.add(second);   // update new list
                set.clear();    // clear set for reusing it
                cur.clear();    // clear cur list for resuing it
                cur.addAll(newList);   // update cur list
                set.add(second.id1);   // update set
                set.add(second.id2);
                if (i == nodes.size() - 1) {  // if reaching the end, add cur into our res list
                    res.add(cur);
                }
            }
            i++;  // move to next node
        }
        return res;
    }
}
