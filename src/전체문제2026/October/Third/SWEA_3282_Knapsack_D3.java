package 전체문제2026.October.Third;

import java.util.*;
import java.io.*;
public class SWEA_3282_Knapsack_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][]dp = new int[N+1][K+1];
            int[]v = new int[N+1];
            int[]w = new int[N+1];
            for(int i=1;i<=N;i++){
                st= new StringTokenizer(br.readLine()," ");
                w[i] = Integer.parseInt(st.nextToken());
                v[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1;i<=N;i++){
                for(int j=0;j<=K;j++){
                    dp[i][j] = dp[i-1][j];
                    if(w[i]<=j){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
                    }
                }
            }
            sb.append("#"+t+" "+dp[N][K]+"\n");
        }
        System.out.println(sb.toString());
    }
}
