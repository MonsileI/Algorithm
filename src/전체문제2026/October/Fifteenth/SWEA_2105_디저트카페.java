package 전체문제2026.October.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_2105_디저트카페 {
    static int N;
    static int[][]map;
    static boolean[]visited;
    static int answer;
    static int[][]move = {{1,1},{1,-1},{-1,-1},{-1,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[101];
            for(int i=0;i<N;i++){
                for(int j=1;j<N-1;j++){
                    dfs(i,j,i,j,0,0,true);
                }
            }
            if(answer==0) answer = -1;
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int oi,int oj,int i,int j,int d,int depth,boolean isFirst){

        if(oi==i&&oj==j&&!isFirst){
            answer = Math.max(answer,depth);
            return;
        }
        isFirst = false;
        //뻗어 나가기
        int ni = i + move[d][0];
        int nj = j + move[d][1];
        if(checkRange(ni,nj)){
            if(!visited[map[ni][nj]]){
                visited[map[ni][nj]] = true;
                dfs(oi,oj,ni,nj,d,depth+1,isFirst);
                visited[map[ni][nj]] = false;
            }
        }
        //방향 바꾸기
        if(d<3){
            ni = i + move[d+1][0];
            nj = j + move[d+1][1];
            if(checkRange(ni,nj)){
                if(!visited[map[ni][nj]]){
                    visited[map[ni][nj]] = true;
                    dfs(oi,oj,ni,nj,d+1,depth+1,isFirst);
                    visited[map[ni][nj]] = false;
                }
            }
        }
    }
    static boolean checkRange(int i,int j){
        if(-1<i&&-1<j&&i<N&&j<N) return true;
        return false;
    }
}
