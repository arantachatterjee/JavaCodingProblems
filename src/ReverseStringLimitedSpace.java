// Reverse a string using O(1) space

public class ReverseStringLimitedSpace {

    public static void main(String[] args) {
        char[] str = {'a', 'r', 'a', 'n', 't', 'a'};
        helper(0, str.length - 1, str);
        for(int i = 0; i < str.length; i++)
            System.out.println(str[i]);
    }

    private static void helper(int start, int end, char[] str) {
        if (start >= end)
            return;
        char temp = str[start];
        str[start] = str[end];
        str[start] = temp;
        helper (start + 1, end - 1, str);
    }

}
