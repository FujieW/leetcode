package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 17:32
 **/
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int sum = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
                max = min;
            } else if (price > max) {
                max = price;
                sum = Math.max(max - min, sum);
            }
        }
        return sum;
    }

}
