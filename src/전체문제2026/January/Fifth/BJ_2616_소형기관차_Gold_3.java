package 전체문제2026.January.Fifth;

import java.util.*;
import java.io.*;
public class BJ_2616_소형기관차_Gold_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]sumArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[][]dp = new int[4][N+1]; //3개를 고름!
        for(int i=1;i<4;i++){
            for(int j=i*M;j<N+1;j++){
                dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j-M] + sumArr[j] - sumArr[j-M]);
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[3][N]);
    }
}
