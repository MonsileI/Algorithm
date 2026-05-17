package 전체문제2026.May.Seventh;

import java.util.Arrays;

public class PR_쿼드압축후개수세기_Level_2 {
    static int[]answer;
    static int N;
    static int[][]board;
    public static void main(String[] args) {
        int[][]arr= {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] solution(int[][] arr) {
        answer = new int[2];
        N = arr.length;
        board = arr;
        dfs(0,0,N);
        return answer;
    }
    static void dfs(int y,int x,int size){

        int shape = board[y][x];
        boolean flag = true;

        OuterLoop:
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(shape!=board[i][j]){
                    flag= false;
                    break;
                }
            }
        }
        if(flag){
            answer[shape]++;
            return;
        }
        dfs(y,x,size/2);
        dfs(y+size/2,x,size/2);
        dfs(y,x+size/2,size/2);
        dfs(y+size/2,x+size/2,size/2);

    }
}
