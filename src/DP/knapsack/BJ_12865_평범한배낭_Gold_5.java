package DP.knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int[]w = new int[N+1]; int[]v = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][G+1];
        for(int i=1;i<N+1;i++){
            int value = v[i]; int weight = w[i];
            for(int j=0;j<G+1;j++){
                dp[i][j] = dp[i-1][j];
                if(weight<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-weight]+value);
                }
            }
        }
        System.out.println(dp[N][G]);
    }
}
