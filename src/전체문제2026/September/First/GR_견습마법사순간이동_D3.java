package 전체문제2026.September.First;

import java.util.*;
import java.io.*;
public class GR_견습마법사순간이동_D3 {
    static int INF = Integer.MAX_VALUE;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M;
    static int[][]map;
    static boolean[][][]visited;
    static int[][]magieMove = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;
        int ei = Integer.parseInt(st.nextToken())-1;
        int ej = Integer.parseInt(st.nextToken())-1;
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = INF;
        Queue<int[]> q= new ArrayDeque<>();
        visited = new boolean[N][M][K+1];
        visited[si][sj][K] = true;
        q.offer(new int[]{si,sj,K,0});
        while(!q.isEmpty()){
            int[]c  =q.poll();
            int i = c[0]; int j =c[1]; int k = c[2]; int cnt = c[3];
            if(i==ei&&j==ej){
                answer = cnt;
                break;
            }
            if(0<k){
                for(int d=0;d<8;d++){
                    int ni = i + magieMove[d][0];
                    int nj = j + magieMove[d][1];
                    if(!canMove(ni,nj,k-1)) continue;
                    visited[ni][nj][k-1]= true;
                    q.offer(new int[]{ni,nj,k-1,cnt+1});
                }
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!canMove(ni,nj,k)) continue;
                visited[ni][nj][k] = true;
                q.offer(new int[]{ni,nj,k,cnt+1});
            }
        }
        System.out.println(answer==INF ? -1 : answer);
    }
    static boolean canMove(int i,int j,int k){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        if(map[i][j]==1) return false;
        if(visited[i][j][k]) return false;
        return true;
    }
}