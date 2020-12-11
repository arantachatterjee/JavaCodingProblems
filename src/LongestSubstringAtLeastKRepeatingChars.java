import java.util.HashMap;

public class LongestSubstringAtLeastKRepeatingChars {

    public static void main(String args[]) {
        //int ans = longestSubstring("ababefgaaaabbbb", 2);
        //System.out.println(ans);
        int ans = longestSubstring("xyuy", 2);
        System.out.println(ans);
    }

    /*public static int longestSubstring(String s, int k) {

        if (s.isEmpty()) return 0;
        if(s.length() <= 1 || k <= 1) return s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int maxLen = 0;
        int currMaxLen = 0;
        int pointer = 0;
        int start = 0; int end = 0;
        while (pointer < s.length()) {
            if (map.get(s.charAt(pointer)) >= k) {
                currMaxLen++;
                end++;
            } else {
                maxLen = Math.max(maxLen, currMaxLen);
                currMaxLen = 0;
                start = pointer;
            }
            pointer++;
        }

        maxLen = Math.max(maxLen, currMaxLen);

        return maxLen;
    }*/

    public static int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || len < k) return 0;
        if (k <= 1) return len;

        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i<len;i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        int l = 0;
        // Find the first character with k occurrences
        while (l < len && freq.get(s.charAt(l)) >= k)
            l++;
        if (l >= len - 1) return l;
        int len_s1 = longestSubstring(s.substring(0, l), k);

        while (l < len && freq.get(s.charAt(l)) < k) l++;
        // If l == len then no substring was found with at least k repeating characters
        int len_s2 = (l < len) ? longestSubstring(s.substring(l), k) : 0;
        return Math.max(len_s1,len_s2);
    }

}