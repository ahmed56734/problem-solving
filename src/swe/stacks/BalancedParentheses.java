package swe.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("())"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> openToClosed = new HashMap<>(3);
        openToClosed.put('{', '}');
        openToClosed.put('[', ']');
        openToClosed.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (openToClosed.containsKey(c)) {
                stack.push(c);
            } else {
                //is closed char
                if (stack.isEmpty() || openToClosed.get(stack.pop()) != c) {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}
