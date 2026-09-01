package 전체문제2026.September.First;

import java.util.*;
import java.io.*;

public class GR_구슬게임_D3 {

    static int MOD = 100000007;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int total = N + M;

        int[][] dp = new int[K + 1][total + 1];

        // 0판, 첫 번째 사람이 N개
        dp[0][N] = 1;

        long answer = 0;

        for (int k = 0; k < K; k++) {

            for (int n = 1; n < total; n++) {

                if (dp[k][n] == 0) continue;

                // 현재 경우의 수
                long cur = dp[k][n];

                // 승
                if (n + 1 == total) {
                    answer = (answer + cur) % MOD;
                } else {
                    dp[k + 1][n + 1] =
                            (int) ((dp[k + 1][n + 1] + cur) % MOD);
                }

                // 패
                if (n - 1 == 0) {
                    answer = (answer + cur) % MOD;
                } else {
                    dp[k + 1][n - 1] =
                            (int) ((dp[k + 1][n - 1] + cur) % MOD);
                }

                // 무승부
                dp[k + 1][n] =
                        (int) ((dp[k + 1][n] + cur) % MOD);
            }
        }

        System.out.println(answer);
    }
}