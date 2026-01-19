package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_13565_침투_Silver_2 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        boolean flag = false;
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        for(int j=0;j<M;j++){
            if(map[0][j]=='0' && !visited[0][j]){
                visited[0][j] = true;
                flag = bfs(0,j);
                if(flag) break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");

    }
    static boolean bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            if(i==N-1) return true;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]=='1') continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
        }
        return false;
    }
}