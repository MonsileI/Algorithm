package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_31863_내진설계_Gold_5 {
    static int N,M;
    static char[][]map;
    static int[][]dist;
    static Queue<int[]> q;
    static int broken;
    static int fine;
    static int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M]; dist=  new int[N][M];
        q = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='@') q.offer(new int[]{i,j});
            }
        }
        //본진
        int[]c = q.poll();
        int i = c[0]; int j = c[1];
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(map[ni][nj]=='|') continue;
            if(map[ni][nj]=='*') q.offer(new int[]{ni,nj});
            dist[ni][nj]--;
            int nni = ni + move[d][0];
            int nnj = nj + move[d][1];
            if(nni<0||nnj<0||N-1<nni||M-1<nnj) continue;
            if(map[nni][nnj]=='|') continue;
            if(map[nni][nnj]=='*')  q.offer(new int[]{nni, nnj});
            dist[nni][nnj]--;
        }
        calc();
        System.out.println(broken+" "+fine);
    }
    static void calc(){

        while(true){
            int size = q.size();
            for(int t=0;t<size;t++){
                int[]c = q.poll();
                int i = c[0]; int j = c[1];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(map[ni][nj]=='|') continue;
                    if(map[ni][nj]=='*' && dist[ni][nj]==0){
                        dist[ni][nj]--;
                        q.offer(new int[]{ni,nj});
                    }
                    if(map[ni][nj]=='#'){
                        if(dist[ni][nj]==-1) q.offer(new int[]{ni,nj});
                        dist[ni][nj]--;
                    }
                }
            }
            if(q.isEmpty()) break;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='*'){
                    if(dist[i][j]<0) broken++;
                    else fine++;
                }
                if(map[i][j]=='#'){
                    if(dist[i][j]<-1) broken++;
                    else fine++;
                }
            }
        }
    }
}
