package com.grayson.normal.simple;


/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RunningSum {
    /**
     * 面向测试用例编程 1
     * @param nums
     * @return
     */
//    public int[] runningSum(int[] nums) {
//        int[] result = new int[nums.length];
//        result[0] = nums[0];
//        for (int i = 1; i < result.length; i++) {
//            result[i] = nums[i] + result[i-1];
//        }
//        result[nums.length-1] = nums[nums.length-1]+result[nums.length-2];
//        return result;
//    }
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

}
