package 전체문제.seven_month_2024_06.second_2024_06_04;

import java.util.*;
import java.io.*;
public class BJ_9465_스티커_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]dp = new int[N+2][2];
            int[][]arr = new int[N+2][2];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=2;i<N+2;i++) arr[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=2;i<N+2;i++) arr[i][1] = Integer.parseInt(st.nextToken());
            for(int i=2;i<N+2;i++){
                dp[i][0] = Math.max(dp[i-1][1],dp[i-2][1]) +arr[i][0];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][0]) +arr[i][1];
            }
            sb.append(Math.max(dp[N+1][0],dp[N+1][1])+"\n");
        }
        System.out.println(sb.toString());

    }
}
