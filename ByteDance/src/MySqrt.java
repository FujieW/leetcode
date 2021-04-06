/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/6 09:09
 **/
public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(4));
    }
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 0;
        int right = x;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            long square = (long) mid * mid;
            long temp = (long) (mid + 1) * (mid + 1);
            if (square <= x && temp > x) {
                return mid;
            }
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }
}
