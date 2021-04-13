import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/13 20:28
 **/
public class MinStack {

    private int min;

    private LinkedList<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (min > val) {
            min = val;
        }
        stack.addLast(val);
    }

    public void pop() {
        Integer last = stack.getLast();
        if (last != min) {
            stack.removeLast();
        } else {
            stack.removeLast();
            min = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                if (integer < min) {
                    min = integer;
                }
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }
}
