package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14923_미로탈출_Gold_4 {
    static int N,M,map[][];
    static int ans = -1;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine()," ");
        int ei = Integer.parseInt(st.nextToken())-1;
        int ej = Integer.parseInt(st.nextToken())-1;
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(si,sj,ei,ej);
        System.out.println(ans);
    }
    static void bfs(int si,int sj,int ei,int ej){
        boolean[][][]visited=  new boolean[N][M][2];
        Queue<int[]> q = new ArrayDeque<>();
        visited[si][sj][0] = true;
        visited[si][sj][1] = true;
        q.offer(new int[]{si,sj,0,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2]; int key = c[3];
            if(i==ei&&j==ej){
                ans = cnt;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==0){
                    if(!visited[ni][nj][key]){
                        visited[ni][nj][key] = true;
                        q.offer(new int[]{ni,nj,cnt+1,key});
                    }
                }else{
                    if(key==0&&!visited[ni][nj][1]){
                        visited[ni][nj][1] = true;
                        q.offer(new int[]{ni,nj,cnt+1,1});
                    }
                }
            }
        }
    }
}
