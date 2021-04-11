/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/11 15:50
 **/
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords words = new ReverseWords();
        System.out.println(words.reverseWords("hello  world"));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        /*char[] chs = s.trim().toCharArray();*/
        String str = s.trim();
        int right = str.length();
        int left = str.length() - 1;
        while (left >= 0) {
            if (str.charAt(left) == ' ') {
                if (str.charAt(left + 1) == ' ') {
                    left--;
                    right--;
                    continue;
                }
                sb.append(str.substring(left + 1, right)).append(" ");
                right = left;
            }
            left--;
        }
        sb.append(str.substring(0, right));
        return sb.toString();
    }
}
