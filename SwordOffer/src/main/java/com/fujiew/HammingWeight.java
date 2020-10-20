package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/20 21:18
 **/
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight2(9));
    }
    // 每次将flag位左移一位，避免了在n右移 且  n 是 负数的情况下出现死循环的情况。
    public static int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 牛逼的解法
    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
