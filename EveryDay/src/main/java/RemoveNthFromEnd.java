import common.ListNode;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/14 15:01
 **/
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 2, 6, 3, 7};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void maopao(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = head;
        ListNode start = head;
        while (n > 0) {
            head = head.next;
            n--;
        }
        if (head == null)
            return pHead.next;
        while (head.next != null) {
            start = start.next;
            head = head.next;
        }
        start.next = start.next.next;
        return pHead;
    }
}
