package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 17:45
 **/
public class SumNums {
    public static void main(String[] args) {
        System.out.println(sumNums(2));
    }

    public static int sumNums(int n) {
        Boolean flag = n > 1 && (n = n + sumNums(n - 1)) > 0;
        return n;
    }
}
