package com.grayson.doublepointer.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author sunhui
 */
public class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a);
    PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        int ls = left.size(),rs = right.size();
        if(ls==rs){
            if(right.isEmpty() || num < right.peek()){
                left.add(num);
            }else{
                left.add(right.poll());
                right.add(num);
            }
        }else{
            if(left.peek() <= num){
                right.add(num);
            }else{
                right.add(left.poll());
                left.add(num);
            }
        }

    }

    public double findMedian() {
        int ls = left.size(),rs = right.size();
        if(ls == rs){
            return (left.peek() + right.peek()) / 2.0;
        }else{
            return left.peek();
        }
    }
}
