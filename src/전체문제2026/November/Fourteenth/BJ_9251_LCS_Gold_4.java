package 전체문제2026.November.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_9251_LCS_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int aLen = a.length;
        int bLen = b.length;
        int[][]dp = new int[aLen+1][bLen+1];
        for(int i=1;i<=aLen;i++){
            for(int j=1;j<=bLen;j++){
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[aLen][bLen]);
    }
}
