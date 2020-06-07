public class ReverseStringRecursive {

    public static void main(String[] args) {
        char[] str = {'a', 'r', 'a', 'n', 't', 'a'};
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if(str == null || index >= str.length)
            return;
        helper(index + 1, str);
        System.out.print(str[index]);
    }
}
