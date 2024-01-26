package 전체문제.second_month_2024_01.sixteenth_2024_01_24;

import java.util.*;
import java.io.*;
public class BJ_17836_공주님을구해라_Gold_5 {
    static int N,M,G;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int ei =0 ; int ej = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    ei = i ; ej = j;
                }
            }
        }
        //그냥 가는 bfs
        int a = bfs(0,0,N-1,M-1);
        //키를 갖고 가는 bfs
        int b = bfs(0,0,ei,ej) + Math.abs(ei-(N-1))+Math.abs(ej-(M-1));
        if(a<=b){
            if(a>G) System.out.println("Fail");
            else System.out.println(a);
        }else{
            if(b>G) System.out.println("Fail");
            else System.out.println(b);
        }
    }
    static int bfs(int si,int sj,int ei,int ej)  {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        boolean[][]visited=new boolean[N][M];
        visited[si][sj] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==ei&&j==ej){
                return cnt;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!=1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        return 987654321;
    }
}
