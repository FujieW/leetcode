import java.util.*;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/6 20:48
 **/
public class OpenLock {
    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        int step = openLock.openLock(new String[]{"9886", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
        // System.out.println(step);
    }



    public int openLock(String[] deadends, String target) {
        //
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) deads.add(deadend);
        //
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        //
        int step = 0;
        q.offer("8886");
        visited.add("8886");

        while (!q.isEmpty()) {
            int sz = q.size();
            //
            for (int i = 0; i < sz; i++) {
                String curr = q.poll();

                // 判断是否在dead集合里
                if (deads.contains(curr))
                    continue;
                if (curr.equals(target))
                    return step;


                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curr, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(curr, j);
                    if (!q.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
