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


    //数学解法

    /**
     * 数组中的每个元素都会在一个或多个奇数长度的子数组中出现，如果可以计算出每个元素在多少个长度为奇数的子数组中出现，即可得到所有奇数长度子数组的和。
     *
     * 对于元素 \textit{arr}[i]arr[i]，记其左边和右边的元素个数分别为 \textit{leftCount}leftCount 和 \textit{rightCount}rightCount，则 \textit{leftCount} = ileftCount=i，\textit{rightCount} = n - i - 1rightCount=n−i−1。如果元素 \textit{arr}[i]arr[i] 在一个长度为奇数的子数组中，则在该子数组中，元素 \textit{arr}[i]arr[i] 的左边和右边的元素个数一定同为奇数或同为偶数（注意 00 也是偶数）。
     *
     * 当元素 \textit{arr}[i]arr[i] 的左边和右边的元素个数同为奇数时，在区间 [0, \textit{leftCount}][0,leftCount] 范围内的奇数有 \textit{leftOdd} = \Big\lfloor \dfrac{\textit{leftCount} + 1}{2} \Big\rfloorleftOdd=⌊
     * 2
     * leftCount+1
     * ​
     *  ⌋ 个，在区间 [0, \textit{rightCount}][0,rightCount] 范围内的奇数有 \textit{rightOdd} = \Big\lfloor \dfrac{\textit{rightCount} + 1}{2} \Big\rfloorrightOdd=⌊
     * 2
     * rightCount+1
     * ​
     *  ⌋ 个，包含元素 \textit{arr}[i]arr[i] 的子数组个数为 \textit{leftOdd} \times \textit{rightOdd}leftOdd×rightOdd；
     *
     * 当元素 \textit{arr}[i]arr[i] 的左边和右边的元素个数同为偶数时，在区间 [0, \textit{leftCount}][0,leftCount] 范围内的偶数有 \textit{leftEven} = \Big\lfloor \dfrac{\textit{leftCount}}{2} \Big\rfloor + 1leftEven=⌊
     * 2
     * leftCount
     * ​
     *  ⌋+1 个，在区间 [0, \textit{rightCount}][0,rightCount] 范围内的偶数有 \textit{rightEven} = \Big\lfloor \dfrac{\textit{rightCount}}{2} \Big\rfloor + 1rightEven=⌊
     * 2
     * rightCount
     * ​
     *  ⌋+1 个，包含元素 \textit{arr}[i]arr[i] 的子数组个数为 \textit{leftEven} \times \textit{rightEven}leftEven×rightEven。
     *
     * 根据上述分析可知，包含元素 \textit{arr}[i]arr[i] 的奇数长度子数组个数为 \textit{leftOdd} \times \textit{rightOdd} + \textit{leftEven} \times \textit{rightEven}leftOdd×rightOdd+leftEven×rightEven，因此元素 \textit{arr}[i]arr[i] 对奇数长度子数组元素和的贡献为 \textit{arr}[i] \times (\textit{leftOdd} \times \textit{rightOdd} + \textit{leftEven} \times \textit{rightEven})arr[i]×(leftOdd×rightOdd+leftEven×rightEven)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/suo-you-qi-shu-chang-du-zi-shu-zu-de-he-yoaqu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
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
