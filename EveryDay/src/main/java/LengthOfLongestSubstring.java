import java.util.HashMap;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/12 14:26
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断窗口是否需要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            length = Math.max(length, right - left);
        }
        return length;
    }
}
