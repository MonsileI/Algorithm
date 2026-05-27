package 전체문제2026.May.Eleventh;

public class PR_순위_Level_2 {
    public static void main(String[] args) {
        int n = 5;
        int[][]results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(n,results));
    }
    static  int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][]board = new boolean[n+1][n+1];
        for(int [] node : results){
            int win = node[0];
            int lose = node[1];
            board[win][lose] = true;

        }
        for(int l=1;l<n+1;l++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j) continue;
                    if(board[i][l] && board[l][j]){
                        board[i][j] = true;
                    }
                }
            }
        }
        for(int i=1;i<n+1;i++){
            boolean flag = true;
            for(int j=1;j<n+1;j++){
                if(i==j) continue;
                if(!board[i][j] && !board[j][i]){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
