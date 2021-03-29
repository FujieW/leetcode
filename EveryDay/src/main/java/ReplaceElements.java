import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 17:09
 **/
public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        ReplaceElements replaceElements = new ReplaceElements();
        System.out.println(Arrays.toString(replaceElements.replaceElements(arr)));
    }

    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                res[i] = -1;
                stack.push(arr[i]);
            } else {
                res[i] = stack.peek();
                if (arr[i] > stack.peek()) {
                    stack.push(arr[i]);
                }
            }
        }
        return res;
    }
}
