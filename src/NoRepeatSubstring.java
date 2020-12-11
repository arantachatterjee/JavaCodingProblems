import java.util.HashMap;

public class NoRepeatSubstring {

    public static int findLength(String str) {

        if (str.length() == 0) return 0;
        if (str.length() == 1) return 1;

        int maxLen = 0;
        int windowEnd = 0;
        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            map.put(str.charAt(windowEnd), map.getOrDefault(str.charAt(windowEnd), 0) + 1);
            if (map.get(str.charAt(windowEnd)) >= 2) {
                while (windowStart < windowEnd) {
                    map.put(str.charAt(windowStart), map.getOrDefault(str.charAt(windowStart), 0) - 1);
                    windowStart++;
                }
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength("abcdef"));
        System.out.println(findLength("abbbb"));
        System.out.println(findLength("uihjnuuuuuuihjnmo"));
    }

}