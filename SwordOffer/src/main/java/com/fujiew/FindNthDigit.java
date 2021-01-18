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
        int count = 9;
        int start = 1;
        while (count < n) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
