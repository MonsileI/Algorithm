package 전체문제2026.September.Sixth;

import java.util.*;
import java.io.*;
public class GR_RGB주차장_D3 {
    static int MOD = 100000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 3;
        for(int i=2;i<=N;i++){
            dp[i] = (dp[i-1]*2) % MOD;
        }
        System.out.println(dp[N]);
    }
}
