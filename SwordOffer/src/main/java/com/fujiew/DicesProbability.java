package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/18 21:45
 **/
public class DicesProbability {
    public double[] dicesProbability(int n) {
        //使得n-1点数概率数组和1点数概率数组元素两两相乘，并将乘积结果加到n点数概率数组上。
        //运算完成后就得到了最终的n点数概率数组。
        //比如n为4,1和1=>2,2和1=>3,3和1=>4  最终得出4中所有可能出现的和的概率

        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            //为n的数组概率
            double mid[] = new double[6 * i - i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int a = 0; a < 6; a++) {
                    //为(n-1)和1的数组概率计算
                    mid[j + a] += pre[j] * (1 / 6d);
                }
            }
            //为n-1的数组概率
            pre = mid;
        }
        return pre;

    }
}
