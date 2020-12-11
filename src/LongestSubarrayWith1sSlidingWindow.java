public class LongestSubarrayWith1sSlidingWindow {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount++; // Keep track of number of ones in current window between windowEnd and windowStart

            if (windowEnd - windowStart + 1 - maxOnesCount > k) { // Check if number of zeros is greater than k
                if (arr[windowStart] == 1)
                    maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubarrayWith1sSlidingWindow.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(LongestSubarrayWith1sSlidingWindow.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
