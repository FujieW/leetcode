package com.fujiew;

import com.fujiew.common.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 10:20
 **/
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (head != null) {
            curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }
}
