package 전체문제2026.April.Third;

import java.util.*;
import java.io.*;
public class BJ_6593_상범빌딩_Gold_5 {
    static int D,N,M;
    static char[][][]map;
    static int answer;
    static boolean[][][]visited;
    static int INF = Integer.MAX_VALUE;
    static int [][]move = {{0,-1,0},{0,0,1},{0,1,0},{0,0,-1},{1,0,0},{-1,0,0}}; //상 우 하 좌 위 아래
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String preEscape = "Escaped in ";
        String suffEscape = " minute(s).";
        String trapped = "Trapped!";
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            D = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(D==0&&N==0&&M==0) break;
            answer = 0;
            map = new char[D][N][M];
            visited = new boolean[D][N][M];
            int si=0; int sj=0; int sf=0;
            for(int f=0;f<D;f++){
                for(int i=0;i<N;i++){
                    String str = br.readLine();
                    for(int j=0;j<M;j++){
                        map[f][i][j] = str.charAt(j);
                        if(map[f][i][j]=='S'){
                            map[f][i][j] = '.';
                            sf = f; si = i ; sj = j;
                            visited[f][i][j] = true;
                        }
                    }
                }
                String str = br.readLine(); // 띄어쓰기;
            }
            int ans = bfs(sf,si,sj);
            if(ans==INF) sb.append(trapped);
            else {
                sb.append(preEscape);
                sb.append(ans);
                sb.append(suffEscape);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int bfs(int z,int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{z,y,x,0});
        int ans = INF;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int d = c[0]; int i = c[1]; int j = c[2]; int cnt = c[3];
            if(map[d][i][j]=='E'){
                ans = cnt;
                break;
            }
            for(int dir=0;dir<6;dir++){
                int nd = d + move[dir][0];
                int ni = i + move[dir][1];
                int nj = j + move[dir][2];
                if(nd<0||ni<0||nj<0||D-1<nd||N-1<ni||M-1<nj) continue;
                if(map[nd][ni][nj]=='#') continue;
                if(visited[nd][ni][nj]) continue;
                visited[nd][ni][nj] = true;
                q.offer(new int[]{nd,ni,nj,cnt+1});
            }

        }
        return ans;
    }
}
