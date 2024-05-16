package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_상범빌딩_Gold_5 {
    static int H,N,M;
    static char[][][]map;
    static int [][] move = {{0,-1,0},{0,0,1},{0,1,0},{0,0,-1},{1,0,0},{-1,0,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            H = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(H==0&&N==0&&M==0) break;
            map = new char[H][N][M];
            int sh =0; int si=0; int sj=0; int eh=0; int ei=0; int ej=0;
            for(int h=0;h<H;h++){
                for(int i=0;i<N;i++){
                    String str = br.readLine();
                    for(int j=0;j<M;j++){
                        map[h][i][j] = str.charAt(j);
                        if (map[h][i][j] == 'S') {
                            map[h][i][j] = '.';
                            sh = h; si = i ; sj = j ;
                        }
                        if(map[h][i][j]=='E'){
                            map[h][i][j] = '.';
                            eh = h; ei = i; ej = j;
                        }
                    }
                }
                br.readLine();
            }
            int ans = bfs(sh,si,sj,eh,ei,ej);
            sb.append(ans==-1 ? "Trapped!" : "Escaped in "+ans+" minute(s).");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int bfs(int sh,int si,int sj,int eh,int ei,int ej){
        boolean[][][]visited = new boolean[H][N][M];
        visited[sh][si][sj] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{sh,si,sj,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int h = c[0]; int i= c[1]; int j = c[2]; int cnt = c[3];
            if(h==eh && i==ei && j ==ej) return cnt;
            for(int d=0;d<6;d++){
                int nh = h + move[d][0];
                int ni = i + move[d][1];
                int nj = j + move[d][2];
                if(!range(nh,ni,nj)) continue;
                if(!visited[nh][ni][nj] && map[nh][ni][nj]=='.'){
                    visited[nh][ni][nj] = true;
                    q.offer(new int[]{nh,ni,nj,cnt+1});
                }
            }
        }

        return -1;
    }

    static boolean range(int h,int i,int j){
        if(h<0||i<0||j<0||H-1<h||N-1<i||M-1<j) return false;
        return true;
    }

}
