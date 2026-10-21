package 전체문제2026.October.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_5644_무선충전 {
    static int[][][]map;
    static int BC;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int N = 10;
        int[][]move = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            BC = Integer.parseInt(st.nextToken());
            int[]moveA = new int[M];
            int[]moveB = new int[M];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++) moveA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++) moveB[i] = Integer.parseInt(st.nextToken());
            map = new int[N][N][BC+1];
            int ai = 0; int aj = 0;
            int bi = N-1; int bj = N-1;
            for(int  tt=1;tt<=BC;tt++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken()); //충전범위
                int p = Integer.parseInt(st.nextToken());
                map[y][x][tt] = p;
                Queue<int[]> q= new ArrayDeque<>();
                boolean[][]visited = new boolean[N][N];
                visited[y][x] = true;
                q.offer(new int[]{y,x,0});
                while(!q.isEmpty()){
                    int[]c = q.poll();
                    int  i = c[0]; int j = c[1]; int cnt = c[2];
                    if(r<=cnt) continue;
                    for(int d=1;d<=4;d++) {
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                        if(visited[ni][nj]) continue;
                        visited[ni][nj] = true;
                        map[ni][nj][tt] = p;
                        q.offer(new int[]{ni,nj,cnt+1});
                    }
                }
            }
            //초기위치
            int answer = calc(ai,aj,bi,bj);
            for(int e=0;e<M;e++){
                ai += move[moveA[e]][0];
                aj += move[moveA[e]][1];
                bi += move[moveB[e]][0];
                bj += move[moveB[e]][1];
                answer += calc(ai,aj,bi,bj);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static int calc(int ai,int aj,int bi,int bj){
        int max = 0;
        for(int c=1;c<=BC;c++){
            int ap = 0;
            int bp = 0;
            if(map[ai][aj][c]!=0) ap = map[ai][aj][c];
            for(int l=1;l<=BC;l++){
                if(map[bi][bj][l]!=0){
                    if(ap==0 || c!=l){
                        bp = Math.max(bp,map[bi][bj][l]);
                    }else{
                        if(ap/2 + map[bi][bj][l]<ap){
                            ap = ap/2;
                            bp = ap;
                        }
                    }
                }
            }
            max = Math.max(max,ap+bp);
        }
        return max;
    }
}
