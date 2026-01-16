package 전체문제2026.January.Ninth;

import java.util.*;
import java.io.*;
public class BJ_11060_점프점프_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        int[]dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int INF = 987654321;
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = INF;
        }
        dp[1] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<i;j++){
                if(dp[j]==INF) continue;
                if((i-j) <= arr[j]){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(dp[N]==INF ? -1 : dp[N]);
    }
}
