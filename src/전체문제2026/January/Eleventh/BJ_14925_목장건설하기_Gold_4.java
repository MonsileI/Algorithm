package 전체문제2026.January.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_14925_목장건설하기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        int[][]dp = new int[N][M];
        int max = 0;
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1 || map[i][j]==2) continue;
                max = dp[i][j] = 1;

            }
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                if(map[i][j]==1 || map[i][j]==2) continue;
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
