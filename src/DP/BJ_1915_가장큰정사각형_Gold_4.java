package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_1915_가장큰정사각형_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]map = new char[N+1][M+1];
        for(int j=0;j<M+1;j++) map[0][j] = '0';
        for(int i=1;i<N+1;i++){
            String str = "0"+br.readLine();
            for(int j=0;j<M+1;j++){
                map[i][j] = str.charAt(j);
            }
        }
        int[][]dp = new int[N+1][M+1];
        int ans = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        System.out.println(ans*ans);
    }
}
