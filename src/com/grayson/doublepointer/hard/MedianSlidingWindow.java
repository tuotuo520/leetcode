package com.grayson.doublepointer.hard;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *  
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *  
 *
 * 提示：
 *
 * 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianSlidingWindow {
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        double[] result = new double[n-k+1];
//        for (int i = 0; i <= n-k; i++) {
//            double[] a = new double[k];
//            for (int j = 0; j < k; j++) {
//                a[j] = nums[i+j];
//            }
//            result[i] = parseArray(a);
//        }
//        return result;
//    }
//
//
//    public  double parseArray(double[] a){
//        Arrays.sort(a);
//        int l = a.length;
//        if(l%2 == 0){
//            return (a[l/2] + a[l/2-1]) / 2.0;
//        }else{
//            return a[l/2];
//        }
//    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int windowsSize = n-k+1;
        double[] result = new double[windowsSize];
        PriorityQueue<Integer> small = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        PriorityQueue<Integer> large = new PriorityQueue<>(Integer::compare);
        for (int i = 0; i < k; i++) large.add(nums[i]);
        //小队列放一半
        for (int i = 0; i < k / 2; i++) small.add(large.poll());
        result[0] = getMid(small, large);
        for (int i = k; i < n; i++) {
            // 人为确保了 right 会比 left 多，因此，删除和添加都与 right 比较（left 可能为空）
            int add = nums[i], del = nums[i - k];
            if (add >= large.peek()) {
                large.add(add);
            } else {
                small.add(add);
            }
            if (del >= large.peek()) {
                large.remove(del);
            } else {
                small.remove(del);
            }
            put(small, large);
            result[i - k + 1] = getMid(small, large);
        }
        return result;
    }

    void put(PriorityQueue<Integer> small,PriorityQueue<Integer> large){
        if (small.size() > large.size()) large.add(small.poll());
        //small只允许比large多一个
        if(large.size() - small.size() > 1) small.add(large.poll());
    }


    //获取数组中位数 大小根堆
    double getMid(PriorityQueue<Integer> small,PriorityQueue<Integer> large){
        //说明是偶数
        if(small.size() == large.size()){
            return small.peek() /2.0 + large.peek() /2.0;
        }else{
            //small优先队列多放一个
            return large.peek();
        }
    }
}
