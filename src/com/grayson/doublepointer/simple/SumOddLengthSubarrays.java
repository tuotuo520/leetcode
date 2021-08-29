package com.grayson.doublepointer.simple;

import java.util.Arrays;

/**
 *
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author sunhu
 */
public class SumOddLengthSubarrays {
//    public int sumOddLengthSubarrays(int[] arr) {
//        int n = arr.length;
//        int result = 0;
//        int gap = 1;
//        do {
//            for (int i = 0; i <= n-gap; ++i) {
//                for (int j = i; j < i+gap;++j) {
//                    result += arr[j];
//                }
//            }
//        }while((gap+=2)<=n);
//        return result;
//
//    }


    //数学解答
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftCount = i,rightCount = n-i-1;
            int leftOdd = (leftCount + 1) /2;
            int rightOdd = (rightCount + 1)/2;
            int leftEven = leftCount / 2 +1;
            int rightEven = rightCount /2 +1;
            result += arr[i] * (leftOdd*rightOdd + leftEven*rightEven);
        }
        return result;
    }

}
