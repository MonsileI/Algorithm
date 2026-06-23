package 전체문제2026.June.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_5685_초등학생_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int MOD = 1234567891;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[][]dp = new int[N-1][21];
            int[]arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            dp[0][arr[0]] = 1;
            for(int i=1;i<N-1;i++){
                int num = arr[i];
                for(int j=0;j<21;j++){
                    if(dp[i-1][j]!=0){
                        if(-1<j-num) dp[i][j-num] = (dp[i][j-num] + dp[i-1][j]) % MOD;
                        if(j+num<21)dp[i][j+num] = (dp[i][j+num] + dp[i-1][j]) % MOD;
                    }
                }
            }
            sb.append("#"+t+" "+dp[N-2][arr[N-1]]+"\n");
        }
        System.out.println(sb.toString());
    }
}
