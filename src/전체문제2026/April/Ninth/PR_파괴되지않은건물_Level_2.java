package 전체문제2026.April.Ninth;

import java.util.Arrays;

public class PR_파괴되지않은건물_Level_2 {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        System.out.println(solution(board,skill));
    }
    static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][]sum = new int[N+1][M+1];

        for(int [] s : skill){
            int type = s[0];
            int fi = s[1];
            int fj = s[2];
            int si = s[3];
            int sj = s[4];
            int p = s[5];
            if(type==1) p *= -1;
            sum[fi][fj] += p;
            sum[fi][sj+1] -= p;
            sum[si+1][fj] -= p;
            sum[si+1][sj+1] +=p;
        }
        for(int i=0;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        for(int j=0;j<M+1;j++){
            for(int i=1;i<N+1;i++){
                sum[i][j] += sum[i-1][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<board[i][j]+sum[i][j]) answer++;
            }
        }
        return answer;
    }
}
