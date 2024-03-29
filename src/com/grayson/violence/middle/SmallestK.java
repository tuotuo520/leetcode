package com.grayson.violence.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author sunhui
 */
public class SmallestK {

//    public int[] smallestK(int[] arr, int k) {
//        int[] ans = new int[k];
//        Arrays.sort(arr);
//        for (int i = 0; i < k; i++) {
//            ans[i] = arr[i];
//        }
//        return ans;
//    }

    //小根堆
//    public int[] smallestK(int[] arr, int k) {
//        int[] ans = new int[k];
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
//        for (int i : arr){
//            priorityQueue.add(i);
//        }
//        for (int i = 0; i < k; i++) {
//            ans[i] = priorityQueue.poll();
//        }
//        return ans;
//    }
//

    public int[] smallestK(int[] arr, int k) {
        return IntStream.of(arr).sorted().limit(k).toArray();
    }

}
