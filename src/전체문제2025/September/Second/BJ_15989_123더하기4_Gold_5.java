package 전체문제2025.September.Second;

import java.util.*;
import java.io.*;
public class BJ_15989_123더하기4_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int[][]dp = new int[10001][4];
        dp[1][1] = 1; //1
        dp[2][1] = 1; //1+1
        dp[2][2] = 1; //2
        dp[3][1] = 1; //1+1+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; //3

        for(int i=4;i<10001;i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int G = Integer.parseInt(br.readLine());
            sb.append((dp[G][1]+dp[G][2]+dp[G][3])+"\n");

        }
        System.out.println(sb.toString());
    }
}
