import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/18 18:13
 **/
public class IsSubsequence {
    public static void main(String[] args) {
        /*"axc"
"ahbgdc"*/
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("", ""));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        int[][] dp = new int[t.length() + 1][26];
        char[] tChars = t.toCharArray();
        for (int i = 0; i < 26; i++) {
            dp[t.length()][i] = t.length();
        }
        for (int i = t.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (tChars[i] != j + 'a') {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = i;
                }
            }
        }
        int add = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dp[add][s.charAt(i) - 'a'] == t.length()) {
                return false;
            }
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
