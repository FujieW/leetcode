import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 16:15
 **/
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
