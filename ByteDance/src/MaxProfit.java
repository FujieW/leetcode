/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/2 09:27
 **/
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            if (price - min >= ans) {
                ans = price - min;
            }
        }
        return ans;
    }
}
