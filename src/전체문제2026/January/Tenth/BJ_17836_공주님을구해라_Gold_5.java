package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_17836_공주님을구해라_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T= Integer.parseInt(st.nextToken());
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int[][]map = new int[N][M];
        boolean[][][]visited = new boolean[N][M][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q= new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0,0});
        int answer = -1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2]; int gram = c[3];
            if(i==N-1&&j==M-1){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int tmp = gram;
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj][gram]) continue;
                if(map[ni][nj]==1){
                    if(tmp==1) {
                        visited[ni][nj][tmp] = true;
                        q.offer(new int[]{ni,nj,cnt+1,tmp});
                    }
                }else{
                    if(map[ni][nj]==2) tmp = 1;
                    visited[ni][nj][tmp] = true;
                    q.offer(new int[]{ni,nj,cnt+1,tmp});
                }
            }
        }

        if(T<answer || answer==-1) System.out.println("Fail");
        else System.out.println(answer);

    }
}
