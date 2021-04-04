import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/4 09:32
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome2("aacabdkacaa"));
        System.out.println(palindrome.longestPalindrome2("cbbd"));
        System.out.println(palindrome.longestPalindrome2("babad"));
        System.out.println(palindrome.longestPalindrome2("aaca"));
    }

    // 中心扩散法
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();

        int start = 0;
        int end = 0;
        for (int i = 0; i < chs.length; i++) {
            int len1 = lenOfPalindrome(chs, i, i);
            int len2 = lenOfPalindrome(chs, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) >> 1);
                end = i + (len >> 1);
            }
        }
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        return s.substring(start, end + 1);
    }

    private int lenOfPalindrome(char[] chs, int i, int j) {
        while (i >= 0 && j < chs.length && chs[i] == chs[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    // 动态规划算法
    public String longestPalindrome2(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        boolean[][] dp = new boolean[len][len];

        // init
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (chs[i] != chs[j]) {
                    dp[i][j] = false;
                } else {
                    // 在相等的情况下，如果只有 chs[i] 和 chs[j] 即 两个相邻（i + 1 = j） 的情况下，直接为true
                    // 否则就等于 dp[i + 1][j - 1]
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i > max) {
                    max = j - i;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
