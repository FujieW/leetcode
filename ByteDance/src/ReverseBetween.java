import common.ListNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/1 11:17
 **/
public class ReverseBetween {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        // 初始化指针
        ListNode g = preHead;
        ListNode p = preHead.next;

        // 将指针移动到想应的位置
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < right - left; i++) {
            ListNode removeNode = p.next;
            p.next = removeNode.next;

            removeNode.next = g.next;
            g.next = removeNode;
        }
        return preHead.next;
    }
}
