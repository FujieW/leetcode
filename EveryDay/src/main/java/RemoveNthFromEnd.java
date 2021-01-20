import common.ListNode;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/14 15:01
 **/
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 2, 1, 6};
        int val = kThNumber(arr, 1);
        System.out.println(val);

        // System.out.println(Arrays.toString(arr));
        // System.out.println(result);
    }

    private static int result;

    public static int kThNumber(int[] arr, int k) {
        return partiction(arr, 0, arr.length - 1, k);
    }

    private static int partiction(int[] arr, int low, int high, int k) {
        int i = low, j = high;
        int pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j--] <= pivot) ;
            arr[i] = arr[j];
            while (i < j && arr[i++] >= pivot) ;
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        if (i + 1 == k) {
            return arr[i];
        } else if (i + 1 > k) {
            return partiction(arr, low, i - 1, k);
        } else {
            return partiction(arr, i + 1, high, k);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        if (i > left + 1)
            quickSort(arr, left, i - 1);
        if (j < right - 1)
            quickSort(arr, i + 1, right);

    }


    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] newArr = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                newArr[k++] = arr[i++];
            } else {
                newArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            newArr[k++] = arr[i++];
        }
        while (j <= right) {
            newArr[k++] = arr[j++];
        }

        if (k >= 0) System.arraycopy(newArr, 0, arr, left, k);
    }


    public static void maopao2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // int min = arr[i];
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
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

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                } else {
                    break;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
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
