package 전체문제2026.February.Ninth;

import java.util.*;
import java.io.*;
public class BJ_14863_서울에서경산까지_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]w = new int[N+1][2];
        int[][]b = new int[N+1][2];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i][0] = Integer.parseInt(st.nextToken());
            w[i][1] = Integer.parseInt(st.nextToken());
            b[i][0] = Integer.parseInt(st.nextToken());
            b[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[K+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 1; i <= N; i++){
            int[] next = new int[K+1];
            Arrays.fill(next, -1);

            int wTime = w[i][0];
            int wValue = w[i][1];
            int bTime = b[i][0];
            int bValue = b[i][1];

            for(int j = 0; j <= K; j++){
                if(dp[j] == -1) continue;

                if(j + wTime <= K){
                    next[j + wTime] = Math.max(
                            next[j + wTime],
                            dp[j] + wValue
                    );
                }

                if(j + bTime <= K){
                    next[j + bTime] = Math.max(
                            next[j + bTime],
                            dp[j] + bValue
                    );
                }
            }

            dp = next;
        }

        int answer = 0;
        for(int j = 0; j <= K; j++){
            answer = Math.max(answer, dp[j]);
        }

        System.out.println(answer);

    }
}
