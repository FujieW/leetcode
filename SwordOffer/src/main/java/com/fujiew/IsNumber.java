package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/12 17:49
 **/
public class IsNumber {
    public static void main(String[] args) {

    }

    public boolean isNumber(String s) {

        if (s == null || s.equals("")) {
            return false;
        }

        //表明判断条件进行判断
        boolean isNum = false;
        boolean isDot = false;
        boolean iseOrE = false;

        //去除空格 并转换为字符数组，方便使用
        char[] chars = s.trim().toCharArray();

        for (int i = 0; i < chars.length; i++) {

            //遇到数字
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNum = true;
            } else if (chars[i] == '.') {
                //遇到小数点
                //小数点之前不能有连续的小数点 或出现E e
                if (isDot || iseOrE) {
                    return false;
                }
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                //遇到E或者e
                //E之前必须有整数，且不能出现重复的E
                if (!isNum || iseOrE) {
                    return false;
                }
                iseOrE = true;
                //重置数字，E之后必须要加数字，防止出现123e 以及123e+这种非法情况
                isNum = false;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    //+ - 号只能出现在开头，或者e或E的后一个位置
                    return false;
                }
            } else {
                //其余可能性均为false;
                return false;
            }
        }

        //因为最后一位必须是数字，若是数字则返回true
        return isNum;
    }
}
