import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/14 11:36
 **/
public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode midNode = findMidNode(head);
        ListNode rightHalf = reverseLink(midNode.next);

        ListNode curr1 = head;
        ListNode curr2 = rightHalf;

        boolean flag = true;
        while (flag && curr2 != null) {
            if (curr1.val != curr2.val) {
                flag = false;
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return flag;
    }

    private ListNode reverseLink(ListNode midNode) {
        ListNode curr = midNode;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }

    private ListNode findMidNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
