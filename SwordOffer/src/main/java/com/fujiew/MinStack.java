package com.fujiew;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/2/1 10:17
 **/
public class MinStack {

    /**
     * initialize your data structure here.
     */
    private final int DEFAULT_CAPACITY = 10;
    int[] stack;
    int size;
    int min;
    public MinStack() {
        stack = new int[DEFAULT_CAPACITY];
        size = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        if (size == stack.length) {
            int[] old = stack;
            stack = new int[size * 2 + 1];
            for (int i = 0; i < size; i++) {
                stack[i] = old[i];
            }
        }
        stack[size++] = x;
    }

    public void pop() {
        if (stack[size-1] != min) {
            size--;
        } else {
            size--;
            if (size > 0) {
                min = stack[0];
                for (int i = 0; i < size; i++) {
                    if (stack[i] < min) {
                        min = stack[i];
                    }
                }
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack[size-1];
    }

    public int min() {
        return min;
    }


}
