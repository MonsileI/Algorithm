package 전체문제.fifth_month_2023_04.ninteenth_2024_04_27;

import java.util.*;
import java.io.*;
public class BJ_2178_미로탐색_Silver_1 {
    static int N,M;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][]visited = new boolean[N][M];
        visited[0][0] = true;
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==N-1 && j==M-1) return cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]=='1'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        return 0;
    }
}
