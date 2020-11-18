import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/18 21:39
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));

        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode head = addTwoNumbers.addTwoNumbers(l1, l2);
        head = head.next;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        int c = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + c;
            c = sum >= 10 ? 1 : 0;
            ListNode temp = new ListNode(sum % 10);
            curr.next = temp;
            curr = temp;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            isNull(l2, curr, c);
        } else {
            isNull(l1, curr, c);
        }
        return head.next;
    }

    private void isNull(ListNode l, ListNode curr, int c) {
        while (l != null) {
            int sum = l.val + c;
            c = sum >= 10 ? 1 : 0;
            ListNode temp = new ListNode(sum % 10);
            curr.next = temp;
            curr = temp;
            l = l.next;
        }
        if (c == 1) {
            curr.next = new ListNode(1);
        }
    }
}
