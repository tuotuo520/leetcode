package com.grayson.violence.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunhui
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            Map<Integer,Integer> map = new HashMap<>(length);
            for (int j = 0; j < length; j++) {
                if(i == j) continue;
                int x = points[i][0] -points[j][0],y = points[i][1] - points[j][1];
                int dist = x * x + y * y;
                map.put(dist,map.getOrDefault(dist ,0) + 1);
            }
            for(int n : map.keySet()){
                int cnt = map.get(n);
                ans += cnt * (cnt - 1);
            }
        }
        return ans;
    }
}
