package 전체문제2026.February.Ninth;

import java.util.*;
import java.io.*;
public class BJ_20002_사과나무_Gold_5 {
    static int[][] dp;
    static int[][] map;
    static int N;
    static int answer = -1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        StringTokenizer st = null;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j - 1] + map[i][j];
                answer = Math.max(answer, map[i][j]);
            }
        }
        for (int j = 1; j < N + 1; j++) {
            for (int i = 1; i < N + 1; i++) {
                dp[i][j] += dp[i - 1][j];
            }
        }
        for (int size = 1; size <= N; size++) {
            for (int i = 0; i + size <= N; i++) {
                for (int j = 0; j + size <= N; j++) {
                    int sum = dp[i + size][j + size]
                            - dp[i + size][j]
                            - dp[i][j + size]
                            + dp[i][j];
                    answer = Math.max(answer, sum);
                }
            }

        }
        System.out.println(answer);
    }
}

