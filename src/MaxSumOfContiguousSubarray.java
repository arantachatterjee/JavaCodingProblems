public class MaxSumOfContiguousSubarray {

    public static int getMaxSumOfContiguousSubarray(int[] arr, int k) {

        if (arr.length == 0 || k > arr.length) return -1;

        int sum = 0; int maxSum = 0;
        int[] arrsum = new int[arr.length - k + 1];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                arrsum[j] = sum;
                maxSum = Math.max(maxSum, sum);
                sum -= arr[j];
                j++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int sum = getMaxSumOfContiguousSubarray(new int[] {1, 2, 3, 4, 5, 6}, 3);
        System.out.println(sum);
        // Contiguous sum array = [6, 9, 12, 15]
        // Max sum = 15
    }
}
