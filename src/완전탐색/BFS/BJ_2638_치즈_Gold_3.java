package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638_치즈_Gold_3 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int sum;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static Queue<int[]> erazeQ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        sum = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) sum++;
            }
        }
        int time = 0;
        erazeQ = new ArrayDeque<>();
        while(true){
            if(sum==0) break;
            calc();
            time++;
        }
        System.out.println(time);
    }

    static void bfs(int y,int x){
        Queue<int[]> q =new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int [] c= q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]){
                    if(map[ni][nj]==0) {
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                    }
                    else if(map[ni][nj]==1) map[ni][nj]= 2;
                }
            }
        }
    }
    static void calc(){

        visited = new boolean[N][M];
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0&&!visited[i][j]){
                    bfs(i,j);
                    break OuterLoop;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==2){
                    int cnt = 0;
                    for(int d=0;d<4;d++){
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(map[ni][nj]==0 && visited[ni][nj]) cnt++;
                        if(cnt>1) break;
                    }
                    if(cnt>1) {
                        map[i][j] = 0;
                        sum--;
                        if(sum==0) return;
                    }else map[i][j] = 1;
                }
            }
        }

    }
}
