package 전체문제2026.May.Twelfth;

import java.util.*;

public class PR_파괴되지않은건물_Level_3 {
    public static void main(String[] args) {
        int[][]board = {{5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};
        System.out.println(solution(board,skill));
    }
    static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][]map = new int[N+1][M+1];
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            if(type==1) {
                degree *= -1;
            }
            map[r1][c1] += degree;
            map[r2+1][c2+1] += degree;
            map[r1][c2+1] -= degree;
            map[r2+1][c1] -= degree;
        }
        for(int i=0;i<N+1;i++) {
            for(int j=1;j<M+1;j++){
                map[i][j] += map[i][j - 1];
            }
        }
        for(int j=0;j<M+1;j++) {
            for(int i=1;i<N+1;i++){
                map[i][j] += map[i-1][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<(map[i][j] + board[i][j])){
                    answer++;
                }
            }
        }
        return answer;
    }
}
