import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/3 10:06
 **/
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("({})((()))))"));
    }

    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chs) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c == ']') {
                if (stack.getLast() != '[')
                    return false;
                else
                    stack.removeLast();
            }
            else if (c == '}') {
                if (stack.getLast() != '{')
                    return false;
                else
                    stack.removeLast();
            }
            else if (c == ')') {
                if (stack.getLast() != '(')
                    return false;
                else
                    stack.removeLast();
            }
        }
        return stack.isEmpty();
    }
}
