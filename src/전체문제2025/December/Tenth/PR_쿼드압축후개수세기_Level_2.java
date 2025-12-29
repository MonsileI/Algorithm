package 전체문제2025.December.Tenth;

import java.util.*;

public class PR_쿼드압축후개수세기_Level_2 {
    static int[]answer;
    static int[][]map;
    public static void main(String[] args) {
        int[][]arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] solution(int[][] arr) {
        answer = new int[2];
        int N = arr.length;
        int M = arr[0].length;
        map = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = arr[i][j];
            }
        }

        //사분면

        dfs(0,0,N,arr[0][0]);

        return answer;
    }
    static void dfs(int y,int x,int size,int shape){
        boolean flag = true;
        OuterLoop:
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j] != shape){
                    flag = false;
                    break OuterLoop;
                }
            }
        }
        if(flag){
            answer[shape]++;
            return;
        }

        dfs(y,x,size/2,map[y][x]);
        dfs(y,x+size/2,size/2,map[y][x+size/2]);
        dfs(y+size/2,x,size/2,map[y+size/2][x]);
        dfs(y+size/2,x+size/2,size/2,map[y+size/2][x+size/2]);

    }

}
