package com.fujiew;

import com.fujiew.common.ListNode;

import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 09:19
 **/
public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(-3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-99);
        ListNode node = deleteNode2(head, -99);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode it = head;
        if (head.val == val) {
            return head.next;
        }
        while (it.next.val != val){
            it = it.next;
        }
        it.next = it.next.next;
        return head;
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode curr = head;
        for (int i = 0; curr != null; i++) {
            if (i == 0) {
                if (curr.val == val) {
                    return curr.next;
                }
            } else {
                prev = prev.next;
            }
            curr = curr.next;
            if (curr.val == val) {
                prev.next = curr.next;
                break;
            }
        }
        return head;
    }
}
