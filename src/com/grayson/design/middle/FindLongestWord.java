package com.grayson.design.middle;

import java.util.Collections;
import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,(a,b)->{
            if (a.length() != b.length()) return b.length() - a.length(); return a.compareTo(b);
        });
        int n = s.length();
        for (String str : dictionary){
            int m = str.length();
            int i = 0,j = 0;
            while(i<n&&j<m){
                if(s.charAt(i) == str.charAt(j)){
                    j++;
                }
                i++;
            }
            if(j == m) return str;
        }
        return "";

    }
}
