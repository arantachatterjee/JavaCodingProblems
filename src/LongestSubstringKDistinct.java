import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int[] charfreq = new int[26];
        int len = str.length();
        int res = 0;
        int distinctChars = 0;
        int start = 0;

        for (int end = 0; end < len; end++) {
            charfreq[str.charAt(end) - 'a'] += 1;
            if (charfreq[str.charAt(end) - 'a'] == 1)
                distinctChars++;
            while (distinctChars > k) {
                charfreq[str.charAt(start) - 'a'] -= 1;
                distinctChars--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }

        return res;
    }

    public static void main (String[] args) {
        System.out.println(findLength("cbbebi", 3));
        System.out.println(findLength("abcac", 2));
    }
}