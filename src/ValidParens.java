/*
Leetcode Problem 20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParens {

    public static void main(String args[]) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {

        int len = s.length();
        if (len == 0)
            return false;

        Map<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && hm.containsKey(c)) {
                char stackChar = stack.peek();
                if(stackChar == hm.get(c))
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }

        return stack.isEmpty();
    }
}