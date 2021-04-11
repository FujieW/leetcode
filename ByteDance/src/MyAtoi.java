/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/11 19:06
 **/
public class MyAtoi {
    public static void main(String[] args) {

    }

    public int myAtoi(String s) {
        char[] chs = s.trim().toCharArray();
        boolean flag = true;
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                int num = chs[i] - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + num;
            } else {
                if (chs[i] == '+' && i == 0) {
                    flag = true;
                } else if (chs[i] == '-' && i == 0) {
                    flag = false;
                } else {
                    break;
                }
            }
        }
        return flag ? res : -res;
    }
}
