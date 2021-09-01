package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution4 {

    public boolean isValidSign_1(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) return false;

        char[] chs = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                if (stack.isEmpty() || stack.peek() != map.get(chs[i])) return false;
                stack.pop();
            } else {
                stack.push(chs[i]);
            }
        }
        return stack.isEmpty();

    }

}
