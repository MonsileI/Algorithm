package 전체문제2026.September.Sixth;

import java.util.*;
import java.io.*;
public class GR_비밀번호찾기_D3 {
    static int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]dp = new int[M+1][N+1];
        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
        }
        for (int i = 2; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j / 2];
                dp[i][j] %= MOD;
            }
        }
        System.out.println(dp[M][N]);
    }
}
