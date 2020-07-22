public class StringPermutations {

    public static void main (String[] args) {
        String s = "abc";
        findPermutations(s, "");
    }

    private static void findPermutations(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix + " ");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            //i-th character of s
            char ch = s.charAt(i);

            //Rest of the string after excluding the i-th character
            String remainingStr = s.substring(0, i) + s.substring(i+1);
            findPermutations(remainingStr, prefix + ch);
        }
    }
}
