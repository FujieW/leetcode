package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/12 17:36
 **/
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        int nthDigit = findNthDigit.findNthDigit(0);
        System.out.println(nthDigit);
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
        int index = (n - 1) % digit;
        return Long.toString(num).charAt(index) - '0';
    }
}
