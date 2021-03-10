/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/9 13:37
 **/
public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        int[] time = new int[]{60,60,60};
        NumPairsDivisibleBy60 by60 = new NumPairsDivisibleBy60();
        System.out.println(by60.numPairsDivisibleBy60(time));
    }
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] seconds = new int[60];
        for (int t : time) {
            seconds[t % 60] += 1;
        }
        count += combination(seconds[30]);
        count += combination(seconds[0]);
        int i = 1, j = 59;
        while (i < j) {
            count += seconds[i++] * seconds[j--];
        }
        return count;
    }

    private int combination(int n) {
        return (n * (n - 1)) >> 1;
    }
}
