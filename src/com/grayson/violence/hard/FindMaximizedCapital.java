package com.grayson.violence.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *
 *
 *
 * @author sunhui
 */
public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> cap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pro = new PriorityQueue<>((a,b)->b-a);
        int ans = w;
        for (int i = 0; i < profits.length; i++) {
            cap.offer(new int[]{capital[i],profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while(!cap.isEmpty() && cap.peek()[0] <= ans) pro.offer(cap.poll()[1]);
            if (pro.isEmpty()) return ans;
            ans += pro.poll();
        }
        return ans;

    }

}
