import java.nio.charset.StandardCharsets;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/2 09:31
 **/
public class AddStrings {
    public static void main(String[] args) {
        AddStrings strings = new AddStrings();
        // System.out.println(strings.addStrings("6", "501"));
        String url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201707%2F20%2F20170720223357_afG3j.thumb.400_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619959901&t=bcd906cc6a61990128613f683082a805";
        System.out.println(url.getBytes(StandardCharsets.UTF_8).length);
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int len = Math.max(num1.length(), num2.length()) + 1;
        char[] ans = new char[len];
        int k = ans.length - 1;
        int i = chs1.length - 1;
        int j = chs2.length - 1;
        int c = 0; // 进位标志
        while (i >= 0 && j >= 0) {
            int sum = chs1[i] - '0' + chs2[j] - '0' + c;
            if (sum >= 10) {
                c = 1;
                sum = sum - 10;
            } else {
                c = 0;
            }
            ans[k] = (char) (sum + '0');
            i--;
            j--;
            k--;
        }
        while (i >= 0) {
            int sum = chs1[i] - '0' + c;
            if (sum >= 10) {
                c = 1;
                sum = sum - 10;
            } else {
                c = 0;
            }
            ans[k] = (char) (sum + '0');;
            i--;
            k--;
        }
        while (j >= 0) {
            int sum = chs2[j] - '0' + c;
            if (sum >= 10) {
                c = 1;
                sum = sum - 10;
            } else {
                c = 0;
            }
            ans[k] = (char) (sum + '0');;
            j--;
            k--;
        }
        if (c == 1) {
            ans[k] = '1';
        }
        return new String(ans).trim();
    }
}
