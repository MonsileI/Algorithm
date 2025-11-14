package 전체문제2025.November.Third;

import java.util.*;
import java.io.*;
public class PR_쿼드압축후개수세기_Level_2 {
    static int[][]map;
    static int[]answer;
    public static void main(String[] args) {
        int[][]arr = {{1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] solution(int[][] arr) {
        int N = arr.length;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = arr[i][j];
            }
        }
        answer = new int[2];
        dfs(0,0,N,map[0][0]);
        return answer;
    }
    static void dfs(int y,int x,int N,int shape){

        boolean flag = true;
        OuterLoop:
        for(int i=y;i<y+N;i++){
            for(int j=x;j<x+N;j++){
                if(map[i][j]!=shape){
                    flag = false;
                    break OuterLoop;
                }
            }
        }
        if(flag){
            answer[shape]++;
        }else{
            dfs(y,x,N/2,map[y][x]);
            dfs(y+N/2,x,N/2,map[y+N/2][x]);
            dfs(y,x+N/2,N/2,map[y][x+N/2]);
            dfs(y+N/2,x+N/2,N/2,map[y+N/2][x+N/2]);
        }
    }
}