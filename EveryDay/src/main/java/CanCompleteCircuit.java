/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 14:51
 **/
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        CanCompleteCircuit circuit = new CanCompleteCircuit();
        System.out.println(circuit.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                index = i;
            }
        }
        return sum < 0 ? -1 : (index + 1) % gas.length;
    }

    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] < 0) {
                continue;
            }
            if (circle(gas, cost, i) == 1) {
                return i;
            }
        }
        return -1;
    }*/

    private int circle(int[] gas, int[] cost, int index) {
        int n = gas.length;
        int end = index;
        int left = 0; // 剩余汽油
        while (true) {
            left += gas[end] - cost[end];
            if (left < 0) {
                return -1;
            }
            end = (end + 1) % n;
            if (left >= 0 && end == index) {
                return 1;
            }
        }
    }
}
