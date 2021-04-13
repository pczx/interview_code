package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode150 {
    public int evalRPN(String[] tokens) {
        List<String> ops = Arrays.asList("+", "-", "*", "/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!ops.contains(token)) {
                stack.push(token);
            } else {
                String value = "";
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    value = String.valueOf(a + b);
                } else if (token.equals("-")) {
                    value = String.valueOf(a - b);
                } else if (token.equals("*")) {
                    value = String.valueOf(a * b);
                } else {
                    value = String.valueOf(a / b);
                }
                stack.push(value);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}