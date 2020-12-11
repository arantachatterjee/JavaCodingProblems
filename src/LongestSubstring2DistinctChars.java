import java.util.HashMap;

public class LongestSubstring2DistinctChars {

    public static int LongestSubstr2DistinctChars(String input) {
        int maxLen = 0;
        int windowEnd = 0;
        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            map.put(input.charAt(windowEnd), map.getOrDefault(input.charAt(windowEnd), 0) + 1);
            while (map.size() > 2) {
                map.put(input.charAt(windowStart), map.get(input.charAt(windowStart)) - 1);
                if (map.get(input.charAt(windowStart)) == 0)
                    map.remove(input.charAt(windowStart));
                windowStart++;
            }
            maxLen = windowEnd - windowStart + 1;
        }

        return maxLen;
    }

    public static void main(String args[]) {
        System.out.println(LongestSubstr2DistinctChars("abcac"));
    }

}
