package jianzhioffer;

import java.util.Stack;

class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                popIndex++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}