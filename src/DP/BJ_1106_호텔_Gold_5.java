package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1106_호텔_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[]dp = new int[C+101];
        int[]w = new int[N];
        int[]v = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,987654321);
        dp[0]=0;
        for(int i=0;i<N;i++){
            int people = v[i];
            int cost = w[i];
            for(int j=people;j<C+101;j++){
                dp[j] = Math.min(dp[j],dp[j-people]+cost);
            }
        }
        int result = 987654321;
        for(int i=C;i<C+101;i++){
            result = Math.min(result,dp[i]);
        }
        System.out.println(result);

    }
}
