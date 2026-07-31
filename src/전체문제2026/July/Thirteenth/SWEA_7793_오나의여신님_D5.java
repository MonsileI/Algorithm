package 전체문제2026.July.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_7793_오나의여신님_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int si = 0; int sj =0;
            Queue<int[]> devil = new ArrayDeque<>();
            char[][]map = new char[N][M];
            boolean[][]virusMap = new boolean[N][M];
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<M;j++){
                    char ch = str.charAt(j);
                    map[i][j] = ch;
                    if(ch=='S'){
                        si = i; sj = j;
                        map[i][j] = '.';
                    }
                    if(ch=='*'){
                        devil.offer(new int[]{i,j});
                        virusMap[i][j] = true;
                    }
                }
            }
            Queue<int[]> q= new ArrayDeque<>();
            q.offer(new int[]{si,sj,0});
            int answer = -1;
            boolean[][]visited = new boolean[N][M];
            visited[si][sj] = true;
            OuterLoop:
            while(true){
                //악마퍼짐
                int dSize = devil.size();
                for(int de=0;de<dSize;de++){
                    int []c = devil.poll();
                    int i = c[0]; int j = c[1];
                    for(int d=0;d<4;d++){
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(map[ni][nj]=='X') continue;
                        if(map[ni][nj]=='D') continue;
                        if(virusMap[ni][nj]) continue;
                        virusMap[ni][nj] = true;
                        map[ni][nj] = '*';
                        devil.offer(new int[]{ni,nj});
                    }
                }
                //수연 이동
                if(q.isEmpty()) break OuterLoop;
                int qSize=  q.size();
                for(int s=0;s<qSize;s++){
                    int[]c = q.poll();
                    int i = c[0];int j=c[1]; int cnt = c[2];
                    if(map[i][j]=='D'){
                        answer = cnt;
                        break OuterLoop;
                    }
                    for(int d=0;d<4;d++){
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(visited[ni][nj]) continue;
                        if(map[ni][nj]=='*') continue;
                        if(map[ni][nj]=='X') continue;
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj,cnt+1});
                    }
                }

            }
            sb.append("#"+t+" ");
            if(answer==-1) sb.append("GAME OVER");
            else sb.append(answer);
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}
