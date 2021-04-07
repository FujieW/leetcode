import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/6 10:43
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode one = new ListNode(5);
        //one.next = new ListNode(9);
        ListNode two = new ListNode(5);
        AddTwoNumbers twoNumbers = new AddTwoNumbers();
        ListNode node = twoNumbers.addTwoNumbers(one, two);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0; // 进位标志
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + c;
            if (sum >= 10) {
                c = 1;
                sum -= 10;
            } else {
                c = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + c;
            if (sum >= 10) {
                c = 1;
                sum -= 10;
            } else {
                c = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + c;
            if (sum >= 10) {
                c = 1;
                sum -= 10;
            } else {
                c = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l2 = l2.next;
        }
        if (c == 1) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}
