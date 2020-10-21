package com.fujiew;

import com.fujiew.common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 10:29
 **/
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode preHead = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
