package com.fujiew;

import javax.xml.bind.annotation.XmlID;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/20 19:45
 **/
public class MinArray {
    public static void main(String[] args) {
        System.out.println(minArray(new int[]{2, 3, 4, 5, 1}));
    }

    public static int minArray(int[] numbers) {
        if (numbers.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = numbers.length-1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]){
                low = mid + 1;
            } else {
                high--;
            }
        }

        return numbers[low];
    }
}
