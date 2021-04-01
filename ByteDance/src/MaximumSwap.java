/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/1 09:09
 **/
public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap swap = new MaximumSwap();
        System.out.println(swap.maximumSwap(10));
    }
    public int maximumSwap(int num) {
        String s = "" + num;
        char[] chs = s.toCharArray();
        int[] index = new int[10];
        // 记录这个数最后一次出现的位置
        for (int i = 0; i < chs.length; i++) {
            index[chs[i] - '0'] = i;
        }

        for (int i = 0; i < chs.length; i++) {
            // 从 9 开始 跟但钱数字比较，如果 9 在这个位置的后面，替换
            for (int j = 9; j > chs[i] - '0'; j--) {
                if (index[j] > i) {
                    swap(chs, i, index[j]);
                    // 因为只能替换一次，所以返回
                    return Integer.parseInt(new String(chs));
                }
            }
        }
        return num;
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
