package 전체문제2026.May.Sixth;

public class PR_가장큰정사각형찾기_Level_2 {
    public static void main(String[] args) {
        int[][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
    static  int solution(int [][]board) {
        int answer =0;
        int N = board.length;
        int M = board[0].length;
        int[][]dp = new int[N][M];
        for(int i=0;i<N;i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(dp[i][0],answer);
        }
        for(int j=0;j<M;j++) {
            dp[0][j] = board[0][j];
            answer = Math.max(dp[0][j], answer);
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                if(board[i][j]==0) continue;
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                answer = Math.max(answer,dp[i][j]);
            }
        }
        return (int)Math.pow(answer,2);
    }

}
