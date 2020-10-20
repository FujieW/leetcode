package com.fujiew;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指Offer第9题，用两个栈实现队列，没啥意思，
 * 按题目要求来可以用两个栈（链表）来回倒腾
 *
 * 更简单的做法，因为 LinkedList 实现了 Deque 接口，所以可以直接用一个LinkedList来实现。 不过这就不符合题意了，哈哈。
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/20 16:56
 **/
public class CQueue {
    LinkedList<Integer> stack1;
    public CQueue() {
        stack1 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }
    public int deleteHead() {
        return stack1.isEmpty() ? -1 : stack1.remove();
    }
}
