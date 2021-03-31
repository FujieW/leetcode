import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/31 09:44
 **/
public class MaxEvents {
    public static void main(String[] args) {
        MaxEvents maxEvents = new MaxEvents();
        int[][] events = new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        maxEvents.maxEvents(events);
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int day = events[0][0];
        int id = 0;
        int n = events.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (id < n || !queue.isEmpty()) {
            // 这一天开始开的会议
            while (id < n && events[id][0] == day) {
                queue.add(events[id][1]);
                id++;
            }
            // 从中选出最近结束的会议
            while (!queue.isEmpty()) {
                Integer top = queue.remove(); // 弹出
                if (top >= day) { // 过滤掉早已结束的会议
                    ans++;
                    break;
                }
            }
            day++;
        }
        return ans;
    }
}
