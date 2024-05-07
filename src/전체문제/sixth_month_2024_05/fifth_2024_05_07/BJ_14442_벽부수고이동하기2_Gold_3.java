package 전체문제.sixth_month_2024_05.fifth_2024_05_07;

import java.util.*;
import java.io.*;
public class BJ_14442_벽부수고이동하기2_Gold_3  {
    static int N,M,K;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] =br.readLine().toCharArray();
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q=  new ArrayDeque<>();
        boolean[][][]visited = new boolean[N][M][K+1];
        visited[0][0][K] = true;
        q.offer(new int[]{0,0,1,K});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];int cnt=c[2]; int k=c[3];
            if(i==N-1&&j==M-1) return cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(k==0){
                    if(map[ni][nj]=='0'){
                        if(!visited[ni][nj][k]){
                            visited[ni][nj][k] = true;
                            q.offer(new int[]{ni,nj,cnt+1,k});
                        }
                    }
                }else{
                    if(map[ni][nj]=='0'){
                        if(!visited[ni][nj][k]){
                            visited[ni][nj][k] = true;
                            q.offer(new int[]{ni,nj,cnt+1,k});
                        }
                    }else{
                        if(!visited[ni][nj][k-1]){
                            visited[ni][nj][k-1] = true;
                            q.offer(new int[]{ni,nj,cnt+1,k-1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
