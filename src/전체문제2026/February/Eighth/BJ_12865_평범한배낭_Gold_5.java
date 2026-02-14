package 전체문제2026.February.Eighth;

import java.util.*;
import java.io.*;
public class BJ_12865_평범한배낭_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]w = new int[N+1];
        int[]v = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][K+1];
        for(int i=1;i<N+1;i++){
            int kg = w[i];
            int value = v[i];
            for(int j=0;j<K+1;j++){
                dp[i][j] = dp[i-1][j];
                if(kg<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-kg]+value);
                }
            }
        }
        for(int i=0;i<N+1;i++) System.out.println(Arrays.toString(dp[i]));
    }
}
