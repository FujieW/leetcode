package com.fujiew;

import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/3 23:02
 **/
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{2, 1, 0};
        int[] poped = new int[]{1, 2, 0};
        System.out.println(validateStackSequences(pushed, poped));

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
