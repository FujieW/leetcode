package com.fujiew;

import com.fujiew.common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/22 17:14
 **/
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode itA = headA;
        ListNode itB = headB;
        while (itA != itB) {
            itA = itA != null ? itA.next : headB;
            itB = itB != null ? itB.next : headA;
        }
        return itA;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 两种方法，
        // 1. 两个栈，将两个链表的元素都压入两个栈中，然后同时弹出元素，直到不相等
        // 2. 找到长的那个，先遍历到跟短的一样长，然后两个再同时遍历，找到相同的

        int lengthA = 0;
        int lengthB = 0;
        ListNode itA = headA;
        ListNode itB = headB;
        lengthA = getLength(itA);
        lengthB = getLength(itB);
        int k = Math.abs(lengthA - lengthB);
        while (k > 0) {
            if (lengthA > lengthB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
            k--;
        }
        // 同时移动
        while (headA != null || headB != null) {
            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }
        return null;

    }

    private int getLength(ListNode it) {
        int length = 0;
        while (it != null) {
            length++;
            it = it.next;
        }
        return length;
    }

}
