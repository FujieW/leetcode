import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/7 10:37
 **/
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 头插法
    public ListNode reverseList3(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = temp;
        }
        return pre.next;
    }

}
