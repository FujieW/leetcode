import common.ListNode;

import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/11 19:22
 **/
public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            stack.add(curr);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            ListNode last = stack.getLast();
            if (last.val != curr.val) {
                return false;
            }
            stack.removeLast();
            curr = curr.next;
        }
        return true;
    }


}
