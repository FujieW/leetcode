import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/9 09:40
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int top = -1;
        for (char c : S.toCharArray()) {
            if (top == -1 || c != stack[top]) {
                stack[++top] = c;
            } else {
                top--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
