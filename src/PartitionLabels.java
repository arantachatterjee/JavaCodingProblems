import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {
        List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res);
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> res= new LinkedList<>(); // Output list
        int[] lastIndexes = new int[26];

        // Populate lastIndexes
        int len = S.length();
        for (int i = 0; i < len; i++) {
            lastIndexes[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < len) {
            int j = i;
            int end = lastIndexes[S.charAt(j) - 'a'];
            while (j < end) {
                end = Math.max(end, lastIndexes[S.charAt(j++) - 'a']);
            }
            res.add(j - i +1);
            i = j + 1;
        }

        return res;
    }

}
