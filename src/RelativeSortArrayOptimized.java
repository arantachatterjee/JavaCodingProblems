import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
Runtime: 2 ms, faster than 66.41% of Java online submissions for Relative Sort Array.
Memory Usage: 39.3 MB, less than 60.08% of Java online submissions for Relative Sort Array.
 */

public class RelativeSortArrayOptimized {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] result = relativeSortArray(arr1, arr2);
        for (int val : result)
            System.out.println(val);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Frequency table
        Arrays.sort(arr1); // Sort arr1 in ascending order

        // Add frequency of elements from arr1 to map
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i]))
                map.put(arr1[i], map.get(arr1[i]) + 1);
            else
                map.put(arr1[i], 1);
        }

        // Add elements to result in the order in which they appear in arr2
        int[] result = new int[arr1.length];
        int resultIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                for (int j = 0; j < map.get(arr2[i]); j++) {
                    result[resultIndex] = (arr2[i]);
                    resultIndex++;
                }
                map.put(arr2[i], -1);
            }
        }

        // Add remaining elements which are not arr2
        for (int i = 0; i < arr1.length; i++) {
            if (map.get(arr1[i]) != -1) {
                result[resultIndex] = arr1[i]; resultIndex++;
            }
        }

        return result;
    }
}
