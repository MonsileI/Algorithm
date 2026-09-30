package 전체문제2026.September.Thirteenth;

import java.util.*;
import java.io.*;
public class GR_발전기_D2 {
    static int [][]map;
    static int N;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    answer++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int y, int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!rangeCheck(ni,nj)) continue;
                if(!visited[ni][nj] && map[ni][nj]==1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||N-1<j) return false;
        return  true;
    }
}
