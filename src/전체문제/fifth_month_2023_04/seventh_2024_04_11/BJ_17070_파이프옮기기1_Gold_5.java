package 전체문제.fifth_month_2023_04.seventh_2024_04_11;

import java.util.*;
import java.io.*;
public class BJ_17070_파이프옮기기1_Gold_5 {
    static int N;
    static int [][] map;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);
        System.out.println(answer);
    }
    static void dfs(int i,int j,int shape){
        if(i==N-1&&j==N-1) {
            answer++;
            return;
        }
        if(shape==0){
            int ni = i + 1;
            int nj = j + 1;
            if(nj<N&&map[i][nj]==0) dfs(i,nj,0); //가로
            if(ni<N&&nj<N){
                if(map[i][nj]==0 && map[ni][j]==0 && map[ni][nj]==0) dfs(ni,nj,1);//대각선
            }
        }
        if(shape==1){
            int ni = i +1;
            int nj = j +1;
            //밀기
            if(ni<N&&nj<N&&map[ni][nj]==0&&map[i][nj]==0&&map[ni][j]==0) dfs(ni,nj,1); //대각선
            //가로
            if(nj<N&&map[i][nj]==0) dfs(i,nj,0);
            //세로
            if(ni<N&&map[ni][j]==0) dfs(ni,j,2);
        }
        if(shape==2){
            int ni = i +1;
            int nj = j + 1;
            if(ni<N&&map[ni][j]==0) dfs(ni,j,2); //세로
            if(ni<N&&nj<N){
                if(map[ni][j]==0 && map[i][nj]==0 && map[ni][nj]==0) dfs(ni,nj,1);//대각선
            }
        }

    }
}
