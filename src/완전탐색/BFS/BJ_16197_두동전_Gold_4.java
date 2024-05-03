package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16197_두동전_Gold_4 {
    static int N,M;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int fi = 0; int fj = 0; int si = 0; int sj = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='o'){
                    if(fi==0){ fi= i ; fj = j;}
                    else {si = i; sj = j;}
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs(fi,fj,si,sj));
    }
    static int bfs(int fy,int fx,int sy,int sx){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{fy,fx,sy,sx,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int fi = c[0]; int fj=c[1]; int si=c[2]; int sj=c[3]; int cnt = c[4];
            if(cnt>10) continue;
            if(range(fi,fj)&&range(si,sj)) continue;
            if(range(fi,fj)!=range(si,sj)) return cnt;

            for(int d=0;d<4;d++){
                int nfi = fi + move[d][0]; int nfj = fj + move[d][1];
                int nsi = si + move[d][0]; int nsj = sj + move[d][1];
                if(!range(nfi,nfj)) {
                    if (map[nfi][nfj] == '#') {
                        nfi = fi;
                        nfj = fj;
                    }
                }
                if(!range(nsi,nsj)) {
                    if (map[nsi][nsj] == '#') {
                        nsi = si;
                        nsj = sj;
                    }
                }
                q.offer(new int[]{nfi,nfj,nsi,nsj,cnt+1});
            }
        }
        return -1;
    }
    static boolean range(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return true;
        return false;
    }
}
