package 전체문제2026.November.Fifteenth;

import java.util.*;
import java.io.*;
public class BJ_1992_쿼드트리_Silver_1 {
    static int N;
    static int[][]map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map  =new int[N][N];
        sb = new StringBuilder();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        dfs(0,0,N);
        System.out.println(sb.toString());
    }
    static void dfs(int i,int j, int size){
        if(size==1){
            sb.append(map[i][j]);
            return;
        }
        boolean flag = true;
        int shape = map[i][j];
        OuterLoop:
        for(int y=i;y<i+size;y++){
            for(int x=j;x<j+size;x++){
                if(map[y][x]!=shape){
                    flag = false;
                    break OuterLoop;
                }
            }
        }
        if(flag){
            sb.append(shape);
            return;
        }
        sb.append("(");
        dfs(i,j,size/2);
        dfs(i,j+size/2,size/2);
        dfs(i+size/2,j,size/2);
        dfs(i+size/2,j+size/2,size/2);
        sb.append(")");
    }
}
