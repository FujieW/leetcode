import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/11 20:51
 **/
public class MiddleNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        MiddleNode middleNode = new MiddleNode();
        ListNode listNode = middleNode.middleNode(head);
        System.out.println(listNode.val);

    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
