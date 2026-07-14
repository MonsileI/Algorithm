package 전체문제2026.July.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_3752_가능한시험점수_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int max = 0;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max += arr[i];
            }
            boolean[][] dp = new boolean[N + 1][max + 1];
            dp[0][0] = true;
            for (int i = 1; i <= N; i++) {
                int num = arr[i - 1];
                for (int j = 0; j <= max; j++) {
                    if(dp[i-1][j]){
                        dp[i][j] = dp[i-1][j];
                        if(j+num<=max){
                            if(dp[i-1][j]){
                                dp[i][j+num] = true;
                            }
                        }
                    }
                }
            }
            int answer = 0;
            for(int i=0;i<=max;i++){
                if(dp[N][i]) answer++;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
