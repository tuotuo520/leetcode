package com.grayson.dynamicprogramming.simple;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * <p>
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * <p>
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * <p>
 * 解题思路：动态规划 暴力递归
 *
 * @author sunhui
 * @version V1.0
 * @Description
 * @Package com.grayson.dynamicprogramming.simple
 * @date 2020/3/24 14:26
 * @ClassName MassagistQuest
 */
public class MassagistQuest {
    public static int massagist(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[n -1];
        }
        int a=0,b=0;
        for(int i=0;i<n;i++){
            int c = Math.max(b,a+nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(massagist(new int[]{2,1,4,5,3,1,1,1,3}));
    }

}
