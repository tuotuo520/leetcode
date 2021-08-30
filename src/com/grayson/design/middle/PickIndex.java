package com.grayson.design.middle;


import java.util.Arrays;
import java.util.Random;

/**
 *
 *
 * 把权重当成区间的长度，就可以利用随机数来随机选取下标了
 * 区间由前缀和生成 查找用二分Arrays.binarySearch()
 * 例如：w[2, 3];
 * 那么前缀和[2, 5];区间[0, 2) 是下标 0，[2, 5)就是 1
 *
 * 作者：delicacy_lang
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight/solution/li-yong-javazi-dai-de-er-fen-cha-zhao-ar-n6wr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class PickIndex {
//    static Random r = new Random(); //生成随机数的类
//    static int[] suf; //前缀和
//    public PickIndex(int[] w) {
//        suf = w;
//        for(int i = 1; i < w.length; ++i)
//            suf[i] = suf[i - 1] + w[i];
//    }
//
//    public int pickIndex() {
//        int num = r.nextInt(suf[suf.length -  1]);
//        int index = Arrays.binarySearch(suf, num);
//        //这个二分法：如果找到这个元素就返回从0开始的下标值
//        //如果找不到：就返回负数，他的绝对值意思是：下标从1算（第一个元素下标为1），它应该插入的位置（第一个比他大的元素，如果没有，就是w.length + 1）
//        if(index >= 0)
//            return index + 1;
//        index = -index;
//        return index - 1;
//
//    }

    /**
     * 官方题解 随机加二分
     */
    int[] pre;
    int total;

    public PickIndex(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
