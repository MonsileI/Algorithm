package 전체문제2026.April.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_3752_가능한시험점수_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=1;t<=TC;t++){
            int N= Integer.parseInt(br.readLine());
            int[]arr = new int[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
            int[][]dp = new int[N+1][10001];
            dp[0][0] = 1;
            int max = 0;
            for(int i=1;i<N+1;i++){
                int num = arr[i];
                for(int j=0;j<10001;j++){
                    if(dp[i-1][j]!=0){
                        dp[i][j] += dp[i-1][j];
                        if(j+num<10001){
                            dp[i][j+num] += dp[i-1][j];
                        }
                        max = Math.max(max,j+num);
                    }
                }
            }
            int answer = 0;
            for(int i=0;i<=max;i++) {
                if(dp[N][i]!=0) answer++;
            }
            sb.append("#"+t+" "+answer+'\n');
        }
        System.out.println(sb.toString());
    }
}
