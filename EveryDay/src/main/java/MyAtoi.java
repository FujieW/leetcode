/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/12 15:18
 **/
public class MyAtoi {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("  ww" + "-2147483649"));
    }

    public int myAtoi(String s) {
        s = s.trim();
        char[] chs = s.toCharArray();
        boolean flag = true; // true 为 正
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            // 数字
            char c = chs[i];
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + num;
            } else {
                // 正负号
                if (c == '+' && i == 0) {
                    flag = true;
                } else if (c == '-' && i == 0) {
                    flag = false;
                } else {
                    break;
                }
            }
        }
        return flag ? res : -res;
    }
}
