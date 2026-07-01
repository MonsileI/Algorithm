package 전체문제2026.June.Eighteenth;

import java.util.*;
import java.io.*;
public class SWEA_5215_햄버거다이어트_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[]v = new int[N+1];
            int[]w = new int[N+1];
            int[][]dp = new int[N+1][K+1];
            for(int i=1;i<N+1;i++){
                st = new StringTokenizer(br.readLine()," ");
                v[i] = Integer.parseInt(st.nextToken());
                w[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1;i<N+1;i++){
                int weight = w[i];
                int value = v[i];
                for(int j=0;j<K+1;j++){
                    dp[i][j] = dp[i-1][j];
                    if(weight<=j){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-weight]+value);
                    }
                }
            }
            sb.append("#"+t+" "+dp[N][K]+"\n");
        }
        System.out.println(sb.toString());
    }
}
