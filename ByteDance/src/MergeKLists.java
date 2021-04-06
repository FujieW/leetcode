import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/6 09:40
 **/
public class MergeKLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return lists[low];
        }
        int mid = low + ((high - low) >> 1);
        ListNode left = mergeKLists(lists, low, mid);
        ListNode right = mergeKLists(lists, mid + 1, high);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return head.next;
    }
}
