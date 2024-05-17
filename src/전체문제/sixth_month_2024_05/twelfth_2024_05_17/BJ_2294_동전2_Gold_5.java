package 전체문제.sixth_month_2024_05.twelfth_2024_05_17;

import java.util.*;
import java.io.*;
public class BJ_2294_동전2_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]dp = new int[N+1][K+1];
        int[]coin = new int[N+1];
        for(int i=1;i<N+1;i++) coin[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<N+1;i++) Arrays.fill(dp[i],987654321);
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++){
            int c = coin[i];
            for(int j=0;j<K+1;j++){
                dp[i][j] = dp[i-1][j];
                if(c<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-c]+1);
                }
            }
        }
        System.out.println(dp[N][K]==987654321 ? -1 : dp[N][K]);
    }
}
