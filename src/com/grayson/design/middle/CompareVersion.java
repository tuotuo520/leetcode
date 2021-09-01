package com.grayson.design.middle;

/**
 * @author sunhui
 */
public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] v1Arg = version1.split("\\.");
        String[] v2Arg = version2.split("\\.");

        for(int n = 0; n < Math.max(v1Arg.length, v2Arg.length); n++){
            int i = (n < v1Arg.length ? Integer.valueOf(v1Arg[n]) : 0);
            int j = (n < v2Arg.length ? Integer.valueOf(v2Arg[n]) : 0);
            if(i < j) {
                return -1;
            } else if(i > j) {
                return 1;
            }
        }
      return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1","1.1"));
    }
}
