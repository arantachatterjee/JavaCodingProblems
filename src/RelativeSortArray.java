import java.util.Arrays;
import java.util.LinkedList;

/*
Runtime: 5 ms, faster than 30% of Java online submissions for Relative Sort Array.
Memory Usage: 39.1 MB, less than 30% of Java online submissions for Relative Sort Array.
*/

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        int[] result = relativeSortArray(arr1, arr2);
        for (int val : result)
            System.out.println(val);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int n = arr1.length; int m = arr2.length;
        LinkedList<Integer> result = new LinkedList<Integer>();

        int i = 0;
        for (i = 0; i < m; i++) { //Look for elements from arr2 in arr1
            for (int j = 0; j < n; j++) {
                if (arr2[i] == arr1[j]) {
                    result.add(arr1[j]);
                    arr1[j] = -1;
                }
                else if (arr1[j] > arr2[i])
                   break;
            }
        }

        for (int k = 0; k < n; k++) { //Append all remaining sorted elements to result
            if (arr1[k] != -1) result.add(arr1[k]);
        }

        int[] output = new int[result.size()];
        i = 0;
        for (int val : result) {
            output[i] = val;
            i++;
        }

        return output;
    }
}
