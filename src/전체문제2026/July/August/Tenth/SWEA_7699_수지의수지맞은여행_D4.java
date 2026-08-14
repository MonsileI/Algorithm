package 전체문제2026.July.August.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_7699_수지의수지맞은여행_D4 {
    static int N,M;
    static char[][]map;
    static boolean[]visited;
    static int answer;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            answer = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
            visited = new boolean[26];
            visited[map[0][0]-'A'] = true;
            dfs(1,0,0);
            sb.append("#"+t+" "+answer+"\n");

        }
        System.out.println(sb.toString());
    }
    static void dfs(int depth, int i,int j){
        answer = Math.max(answer,depth);
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            char ch = map[ni][nj];
            if(visited[ch-'A']) continue;
            visited[ch-'A'] = true;
            dfs(depth+1,ni,nj);
            visited[ch-'A'] = false;
        }

    }
}
