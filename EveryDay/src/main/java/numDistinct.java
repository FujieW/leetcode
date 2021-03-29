import java.util.HashMap;
import java.util.HashSet;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/17 20:45
 **/
public class numDistinct {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        char[] chs = s.toCharArray();
        return 0;
    }
}
