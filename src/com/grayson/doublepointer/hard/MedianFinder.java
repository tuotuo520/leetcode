package com.grayson.doublepointer.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

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
