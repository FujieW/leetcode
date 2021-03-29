import common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/12 20:21
 **/
public class AliTest {
    public static void main(String[] args) {
        AliTest test = new AliTest();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }


}
