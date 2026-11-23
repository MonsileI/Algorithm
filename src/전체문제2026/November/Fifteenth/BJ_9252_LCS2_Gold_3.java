package 전체문제2026.November.Fifteenth;

import java.util.*;
import java.io.*;
public class BJ_9252_LCS2_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[]aArr = br.readLine().toCharArray();
        char[]bArr = br.readLine().toCharArray();
        int aLen = aArr.length;
        int bLen = bArr.length;
        int[][]dp = new int[aLen+1][bLen+1];
        for(int i=1;i<=aLen;i++){
            for(int j=1;j<=bLen;j++){
                if(aArr[i-1]==bArr[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        int i = aLen;
        int j = bLen;
        while(0<i && 0<j){
            if(i==0||j==0) break;
            if(dp[i][j]==dp[i-1][j]) i--;
            else if(dp[i][j]==dp[i][j-1]) j--;
            else{
                sb.append(aArr[i-1]);
                i--;j--;
            }
        }
        System.out.println(dp[aLen][bLen]);
        System.out.println(sb.reverse().toString());
    }
}
