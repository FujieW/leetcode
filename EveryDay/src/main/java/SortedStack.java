import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 17:30
 **/
class SortedStack {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public SortedStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int val) {
        if (stack1.isEmpty()) {
            stack1.push(val);
        } else {
            while (!stack1.isEmpty() && stack1.peek() < val) {
                stack2.push(stack1.pop());
            }
            stack1.push(val);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
        }
    }

    public int peek() {
        return isEmpty() ? -1 : stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */