package 전체문제2026.February.Fifth;

import java.util.*;
import java.io.*;
public class BJ_1987_알파벳_Gold_4 {
    static int N,M;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    static boolean[]alpha;
    static char[][]map;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        alpha = new boolean[27];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        alpha[map[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(answer);
    }
    static void dfs(int i,int j,int sum){
        answer = Math.max(answer,sum);

        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(visited[ni][nj]) continue;
            if(alpha[map[ni][nj]-'A']) continue;
            visited[ni][nj] = true;
            alpha[map[ni][nj]-'A'] = true;
            dfs(ni,nj,sum+1);
            visited[ni][nj] = false;
            alpha[map[ni][nj]-'A'] = false;
        }
    }
}
