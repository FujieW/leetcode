import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/14 14:41
 **/
public class HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
