package com.fujiew;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/11 11:39
 **/
/**
 *
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxQueue {

    private PriorityQueue<Integer> queue;
    private LinkedList<Integer> list;
    public MaxQueue() {
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        list = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public void push_back(int value) {
        list.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer first = list.removeFirst();
        queue.remove(first);
        return first;
    }


}
