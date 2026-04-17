package 전체문제2026.April.Tenth;

import java.util.*;
import java.io.*;
public class BJ_1726_로봇_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][]visited = new int[N][M][4];
        int[][]map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) Arrays.fill(visited[i][j],INF);
        }
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken()) -1;
        int sj = Integer.parseInt(st.nextToken()) -1;
        int sd = Integer.parseInt(st.nextToken()) -1;
        st = new StringTokenizer(br.readLine()," ");
        int ei = Integer.parseInt(st.nextToken()) -1;
        int ej = Integer.parseInt(st.nextToken()) -1;
        int ed = Integer.parseInt(st.nextToken()) -1;
        // 상우하좌로 바꿔주기 (지금은 동서남북)
        sd = changeDir(sd); ed = changeDir(ed);

        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}}; // 상 우 하 좌
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,sd,0});
        int answer = INF;
        visited[si][sj][sd] = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int d = c[2]; int cnt = c[3];
            if(answer<cnt) break;
            if(i==ei && j==ej){
                if(d==ed){
                    answer = cnt;
                    continue;
                }else{
                    //0일때 1일때 2일때 3일때
                    int diff = Math.abs(d-ed);
                    if(diff==3) diff = 1;
                    answer = Math.min(answer,(cnt+diff));
                    continue;
                }
            }

            for(int k=1;k<4;k++) {
                int ni = i + (move[d][0]*k);
                int nj = j + (move[d][1]*k);
                if (-1 < ni && -1 < nj && ni < N && nj < M) {

                    if(map[ni][nj]==1) break;

                    if (visited[ni][nj][d] > (cnt+1) && map[ni][nj] == 0) {
                        visited[ni][nj][d] = (cnt+1);
                        q.offer(new int[]{ni, nj, d, cnt + 1});
                    }
                }

            }
            //오른쪽
            int rd = (d+1)%4;
            if(visited[i][j][rd] > (cnt+1)){
                visited[i][j][rd] = (cnt+1);
                q.offer(new int[]{i,j,rd,cnt+1});
            }
            int ld = (d+3)%4;
            if(visited[i][j][ld] > (cnt+1)){
                visited[i][j][ld] = (cnt+1);
                q.offer(new int[]{i,j,ld,cnt+1});
            }
        }
        System.out.println(answer);
    }
    static int changeDir(int d){
        switch(d){
            case 0 : d = 1;
                break;
            case 1 : d = 3;
                break;
            case 2 : d = 2;
                break;
            case 3 : d = 0;
                break;
        }
        return d;
    }
}
