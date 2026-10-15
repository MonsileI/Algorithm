package 전체문제2026.October.Eighth;

import java.util.Arrays;

public class PR_파괴되지않은건물_Level_3 {
    public static void main(String[] args) {
        int[][]board = {{5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};
        System.out.println(solution(board,skill));
    }
    static  int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][]dp = new int[N+1][M+1];
        for(int [] s : skill){
            int type = s[0];
            int fi = s[1];
            int fj = s[2];
            int si = s[3];
            int sj = s[4];
            int d = s[5];
            if(type==1) d *= -1;
            dp[fi][fj] += d;
            dp[fi][sj+1] -= d;
            dp[si+1][fj] -= d;
            dp[si+1][sj+1] += d;
        }
        for(int i=0;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] += dp[i][j-1];
            }
        }
        for(int j=0;j<=M;j++) {
            for (int i = 1; i <= N; i++) {
                dp[i][j] += dp[i-1][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0 < board[i][j] + dp[i][j]){
                    answer++;
                }
            }
        }
        return answer;
    }
}
