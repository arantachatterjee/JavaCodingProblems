import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int subLen = s.length();
        int matched = 0;
        int subStrStart = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (map.containsKey(s.charAt(windowEnd))) {
                map.put(s.charAt(windowEnd), map.get(s.charAt(windowEnd)) - 1);
                if (map.get(s.charAt(windowEnd)) >= 0)
                    matched++;
            }

            while (matched == t.length()) {
                if (subLen > windowEnd - windowStart + 1) {
                    subStrStart = windowStart;
                    subLen = windowEnd - windowStart + 1;
                }

                if (map.containsKey(s.charAt(windowStart))) {
                    if (map.get(s.charAt(windowStart)) == 0)
                        matched--;
                    map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) + 1);
                }
                windowStart++;
            }
        }

        return subLen > s.length() ? "" : s.substring(subStrStart, subStrStart + subLen);
    }

    public static void main(String args[]) {
        System.out.println(minWindow("AhuBuiCoooABC", "ABC"));
        //System.out.println(findSubstring("AhuBuiCoooABCeerhhgtfA", "ABC"));
    }
}