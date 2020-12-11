public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        if (arr.length == 0) return 0;

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        // i denotes WindowEnd and j denotes WindowStart
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= S && j < arr.length) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= arr[j];
                j++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main (String[] args) {
        System.out.println(findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));
    }

}