package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/12 17:36
 **/
public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Character.isDigit('e'));
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long count = 9;
        long start = 1;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
