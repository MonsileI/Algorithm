package 전체문제2026.November.Seventeenth;

import java.util.*;
import java.io.*;
public class BJ_2294_동전2_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]coin = new int[N+1];
        for(int i=1;i<=N;i++) coin[i] = Integer.parseInt(br.readLine());
        int[][]dp = new int[N+1][K+1];
        int INF = 987654321;
        for(int i=0;i<=N;i++) Arrays.fill(dp[i],INF);
        dp[0][0] = 0;
        for(int i=1;i<=N;i++){
            int c = coin[i];
            for(int j=0;j<=K;j++){
                dp[i][j] = dp[i-1][j];
                if(c<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-c]+1);
                }
            }
        }
        int answer = dp[N][K];
        System.out.println(answer == INF ? -1 : answer);
    }
}