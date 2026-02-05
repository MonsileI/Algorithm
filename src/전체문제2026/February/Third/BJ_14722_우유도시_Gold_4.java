package 전체문제2026.February.Third;

import java.util.*;
import java.io.*;
public class BJ_14722_우유도시_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]map = new int[N+1][N+1];
        StringTokenizer st = null;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[N+1][N+1][3];
        int INF = -987654321;
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                Arrays.fill(dp[i][j],INF);
            }
        }

        // 시작점: 아무것도 안 먹은 상태만 가능
        dp[1][1][2] = 0;
        if(map[1][1]==0) dp[1][1][0] = 1;

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (i == 1 && j == 1) continue;
                int num = map[i][j];
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i][j - 1][2]);

                if (num == 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], Math.max(dp[i][j - 1][2], dp[i - 1][j][2]) + 1);
                }
                if (num == 1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + 1);
                }
                if (num == 2) {
                    dp[i][j][2] = Math.max(dp[i][j][2], Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + 1);
                }
            }
        }
        System.out.println(Math.max(dp[N][N][0], Math.max(dp[N][N][1], dp[N][N][2])));
    }
}
