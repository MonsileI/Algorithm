package 전체문제2026.June.Ninth;

import java.util.Arrays;

public class PR_정수삼각형_Level_3 {
    public static void main(String[] args) {
        int[][]triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
    static int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][]dp = new int[N][N];
        for(int i=0;i<N;i++){
            if(triangle[i].length<i) continue;
            int j;
            for(j=0;j<=i;j++){
                dp[i][j] = triangle[i][j];
            }
            for(;j<N;j++){
                dp[i][j] = -1;
            }
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                if(dp[i-1][j]==-1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    break;
                }
                if(j==0) {
                    dp[i][j] =dp[i-1][j] + triangle[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
            }
        }
        for(int j=0;j<N;j++) answer = Math.max(answer,dp[N-1][j]);
        return answer;
    }
}
