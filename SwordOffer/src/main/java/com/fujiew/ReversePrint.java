package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/19 23:42
 **/
public class ReversePrint {
    public static void main(String[] args) {

    }
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }
        // 重新将pointer 指向 头节点
        pointer = head;
        int[] newArray = new int[length];
        int i = length - 1;
        while (i>=0) {
            newArray[i--] = pointer.val;
            pointer = pointer.next;
        }
        return newArray;
    }
}
