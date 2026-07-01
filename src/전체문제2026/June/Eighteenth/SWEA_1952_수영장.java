package 전체문제2026.June.Eighteenth;

import java.util.*;
import java.io.*;
public class SWEA_1952_수영장 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            int[]arr = new int[4];
            for(int i=0;i<4;i++) arr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            int[]dp = new int[13];
            dp[0] = 0;
            for(int i=1;i<=12;i++) {
                  int day = Integer.parseInt(st.nextToken());
                  dp[i] = dp[i-1]+ day * arr[0];
                  dp[i] = Math.min(dp[i],dp[i-1]+arr[1]);

                  if(3<=i){
                      dp[i] = Math.min(dp[i],dp[i-3]+arr[2]);
                  }else{
                      dp[i] = Math.min(dp[i],arr[2]);
                  }
            }
            int answer = Math.min(dp[12],arr[3]);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
