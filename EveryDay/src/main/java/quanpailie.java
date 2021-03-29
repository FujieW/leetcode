import java.util.*;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/15 14:07
 **/
public class quanpailie {
    public static void main(String[] args) {
        quanpailie quanpailie = new quanpailie();
        System.out.println(Arrays.toString(quanpailie.permutation("abc")));
    }

    private List<String> res = new ArrayList<>();
    private HashSet<String> set = new HashSet<>();

    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Character> result = new ArrayList<>();
        dfs(chs, result);
        String[] strs = new String[res.size()];
        int i = 0;
        for (String re : res) {
            strs[i++] = re;
        }
        return strs;
    }

    public void dfs(char[] chs, List<Character> result) {
        if (result.size() == chs.length) {

            System.out.println(result);
            return;
        }
        for (char ch : chs) {
            if (result.contains(ch)) {
                continue;
            }
            result.add(ch);
            dfs(chs, result);
            result.remove(result.size() - 1);
        }
    }
}
