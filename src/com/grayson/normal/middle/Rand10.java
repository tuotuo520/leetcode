package com.grayson.normal.middle;

/**
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 *
 * 输入: 3
 * 输出: [8,1,10]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author sunhu
 */
public class Rand10 {
//    public int rand10() {
//        int ans = rand2();
//        for (int i = 0; i < 3; i++) {
//            ans <<= 1;
//            ans ^= rand2();
//        }
//        return (ans <= 10 && ans >=0) ? ans : rand10();
//    }
//
//    public int rand2(){
//        int ans = rand7();
//        return ans == 7 ? rand2() : ans % 2;
//    }

//    public int rand10() {
//        while (true) {
//            int ans = (rand7() - 1) * 7 + (rand7() - 1); // 进制转换
//            if (1 <= ans && ans <= 10) return ans;
//        }
//    }
//
//    public int rand10() {
//        while (true) {
//            int ans = (rand7() - 1) * 7 + (rand7() - 1); // 进制转换
//            if (1 <= ans && ans <= 40) return ans % 10 + 1;
//        }
//    }
//
//public  int rand10(){
//int l =rand2();
//int r = rand5();
//return l == 0 ? r : r+5;
//}
//
//public int rand5(){
//       int cal = rand7();
//       while(cal > 5){
//           cal = rand7();
//       }
//       return cal;
//    }
//
//    public  int rand2(){
//        int cal = rand7();
//        while(cal == 7){
//            cal = rand7();
//        }
//        return cal;
//    }


    public int rand10(){
        return (rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()) % 10 + 1;
    }
}
