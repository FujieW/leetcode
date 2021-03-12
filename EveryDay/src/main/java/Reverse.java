/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/12 14:56
 **/
public class Reverse {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse.reverse(123));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int num = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num < -8)) {
                return 0;
            }

            res = res * 10 + num;
        }
        return res;
    }
}
