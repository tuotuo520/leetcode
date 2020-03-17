package com.grayson.simple.doublepointer;

/**
 *字符串压缩。
 *利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 *比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 *你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * @author sunhui
 * @version V1.0
 * @Description
 * @Package com.grayson.simple
 * @date 2020/3/16 15:09
 * @ClassName StringCompression
 */
public class StringCompression {
    public static String stringCompression(String S) {
        StringBuilder sb = new StringBuilder();
        //字符串先拆解成数组
        char[] arr = S.toCharArray();
        int s = 0, e = 0, count = 0;
        while (s < arr.length) {
            while(e < arr.length && arr[s] == arr[e]){
                e++;
                count++;
            }
            sb.append(arr[s]).append(count);
            s = e;
            count = 0;
        }
        return sb.length() > S.length() ? S : sb.toString();
    }


    public static void main(String[] args) {
        String a = "accccaaaddf";
        System.out.println(stringCompression(a));
    }
}
