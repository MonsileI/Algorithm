package 전체문제2026.January.SIxth;

import java.util.*;

public class LC_11_ContainerWithMostWater_Medium {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int l = 0; int r = height.length-1;
        int max = 0;
        while(l<r){
            int min = Math.min(height[l],height[r]);
            max = Math.max(max,(min*(r-l)));
            if(height[l]<height[r]) l++;
            else r--;
        }
        System.out.println(max);
    }
}
