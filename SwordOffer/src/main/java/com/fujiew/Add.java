package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/30 15:51
 **/
public class Add {
    public static void main(String[] args) {
        int a = 0;
        System.out.println(~a + 1);
    }

    /**
     * 1. 采用异或求得a与b的不带进位和
     * 2. 采用与求得进位和，因为进位，所以需要将进位和左移一位
     * 3. 循环遍历，直到进位和为0时结束循环得到结果
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
