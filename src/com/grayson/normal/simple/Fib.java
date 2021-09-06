package com.grayson.normal.simple;

/**
 English description is not available for the problem. Please switch to Chinese.
 Related Topics 记忆化搜索 数学 动态规划 👍 223 👎 0
 * @author sunhu
 */
public class Fib {
//    public int fib(int n) {
//        if(n<2) return n;
//        int mod = 1000000007;
//        int p =0,q=0,r=1;
//        for (int i = 2; i <= n ; i++) {
//            p = q;
//            q = r;
//            r = (p + q) % mod;
//        }
//        return  r;
//    }


    static int mod = (int) (1e9+7);
    static int m = 101;
    static int[] cache = new int[m];

    static {
        cache[1] = 1;
        for (int i = 2; i < m ; i++) {
        cache[i] = cache[i-1] + cache[i-2];
        cache[i] %= mod;
        }
    }

    public int fib(int n){
        return cache[n];
    }
}
