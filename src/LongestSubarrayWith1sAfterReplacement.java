public class LongestSubarrayWith1sAfterReplacement {
    public static int findLength(int[] arr, int k) {
        int maxLen = 0;
        int start = 0, end = 0;

        for (end = 0; end < arr.length; end++) {
            int replacementnums = k;
            start = end;
            while (start < arr.length && (replacementnums != 0 || arr[start] == 1)) {
                if (arr[start] == 0)
                    replacementnums--;
                start++;
            }
            maxLen = Math.max(maxLen, start - end);
        }

        return maxLen;
    }

    public static void main (String[] args) {
        System.out.println("[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k = 2 \nOutput:" + findLength(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println("[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k = 3 \nOutput:" + findLength(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
