import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Solution {

    public static void main(String[] arsg) {
        List<String> res = topKFrequent(new String[] {"i", "i", "am", "awesome", "jk", "jk"}, 3);
        System.out.println(res);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Frequency table
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }

        // Heap: sort in descending order of frequency and compare words when frequency is the same
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2)
        );

        // Populate heap with k most frequent words
        for (String word : map.keySet()) {
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }

        // Populate result
        List<String> res = new LinkedList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }

        // Reverse result and return
        Collections.reverse(res);
        return res;
    }
}