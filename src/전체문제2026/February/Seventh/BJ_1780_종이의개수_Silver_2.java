package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_1780_종이의개수_Silver_2 {
    static int N;
    static int [][]map;
    static int []answer;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }
        answer = new int[3];
        dfs(0,0,map[0][0],N);
        for(int d=0;d<3;d++) System.out.println(answer[d]);

    }
    static void dfs(int y,int x,int shape,int size){

        boolean flag = true;
        OuterLoop:
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j]!=shape){
                    flag = false;
                    break OuterLoop;
                }
            }
        }
        if(flag){
            answer[shape]++;
            return;
        }
        int fy = y;
        int sy = y+(size/3);
        int ty = y+((size/3)*2);
        int fx = x;
        int sx = x+(size/3);
        int tx = x+((size/3)*2);

        dfs(fy,fx,map[fy][fx],size/3);
        dfs(fy,sx,map[fy][sx],size/3);
        dfs(fy,tx,map[fy][tx],size/3);

        dfs(sy,fx,map[sy][fx],size/3);
        dfs(sy,sx,map[sy][sx],size/3);
        dfs(sy,tx,map[sy][tx],size/3);

        dfs(ty,fx,map[ty][fx],size/3);
        dfs(ty,sx,map[ty][sx],size/3);
        dfs(ty,tx,map[ty][tx],size/3);
    }
}