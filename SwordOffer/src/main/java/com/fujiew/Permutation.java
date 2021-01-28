package com.fujiew;

import java.util.*;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/27 17:03
 **/
public class Permutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation2("t")));
    }


    List<String> res = new LinkedList<>();
    static char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    private static Set<String> hashSet = new HashSet<>();
    public static String[]  permutation2(String s) {
        LinkedList<String> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        permutation(res, chars, 0);
        return res.toArray(new String[res.size()]);
    }

    private static void permutation(LinkedList<String> res, char[] chars, int index) {
        if (index == chars.length - 1) {
            String s = new String(chars);
            if (!hashSet.contains(s)) {
                res.add(s);
                hashSet.add(s);
            }
        } else {
            for (int i = index; i < chars.length; i++) {
                // 判断用来减少交换次数
                if (i != index) {
                    swap(chars, i, index);
                }
                permutation(res, chars, index + 1);
                if (i != index) {
                    swap(chars, i, index);
                }
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
