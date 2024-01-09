package 전체문제.second_month_2024_01.sixth_2024_01_09;

public class PR_파괴되지않은건물_Level_3 {


    static int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][]map = new int[N+1][M+1];

        int size = skill.length;
        for(int i=0;i<size;i++){
            int type = skill[i][0];
            int fi = skill[i][1]; int fj = skill[i][2]; int si = skill[i][3]+1; int sj = skill[i][4]+1;
            int degree = skill[i][5];
            if(type==1) degree *= -1;
            map[fi][fj] += degree;
            map[fi][sj] -= degree;
            map[si][fj] -= degree;
            map[si][sj] += degree;
        }

        //오른쪽
        for(int i=0;i<N+1;i++){
            int sum = 0;
            for(int j=0;j<M+1;j++){
                sum += map[i][j];
                map[i][j] = sum;
            }
        }

        //왼쪽
        for(int j=0;j<M+1;j++){
            int sum = 0;
            for(int i=0;i<N+1;i++){
                sum += map[i][j];
                map[i][j] = sum;
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]+map[i][j]>0) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        result = 10;
        2.
        int[][]board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][]skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        result = 6;
        * */
        int[][]board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution(board,skill));
    }
}
