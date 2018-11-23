import java.util.*;

public class FindTopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> res = topKFrequent(words1, k);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    /**
     * For a composition with different kinds of words,
     * try to find the top k frequent words from the composition
     * @param words
     * @param k
     * @return
     */
    private static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        // b.getKey().compareTo()说明是按照降序排列
        // 如果是a.getKey().compareTo() 则说明是按照升序排列
        // 整个priorityQueue是一个最小堆，如果a跟b的value相同，则按照a跟b的key值来降序排列，否则按照a跟b的value值来升序排列
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res;
    }


}

