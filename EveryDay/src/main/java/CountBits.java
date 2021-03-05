import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/3 08:28
 **/
public class CountBits {
    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(Arrays.toString(countBits.countBits(2)));
    }

    public int[] countBits(int num) {
        int[] numOfOne = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int n = i;
            int count = 0;
            while (n != 0) {
                count++;
                n = (n - 1) & n;
            }
            numOfOne[i] = count;
        }
        return numOfOne;
    }
}
