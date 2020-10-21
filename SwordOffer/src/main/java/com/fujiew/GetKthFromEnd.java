package com.fujiew;

import com.fujiew.common.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 15:31
 **/
public class GetKthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr = head;
        while (curr != null) {
            k--;
            if (k <= 0) {
                head = head.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
