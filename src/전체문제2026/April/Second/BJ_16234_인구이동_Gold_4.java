package 전체문제2026.April.Second;

import java.util.*;
import java.io.*;
public class BJ_16234_인구이동_Gold_4 {
    static int N;
    static int L,R;
    static int [][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while(true){
            boolean flag = false;
            int basic = map[0][0];
            OuterLoop:
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(basic!=map[i][j]){
                        flag = true;
                        break OuterLoop;
                    }
                }
            }
            if(!flag) break;
            flag = false;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                         if(bfs(i,j)){
                             flag = true;
                         }
                    }
                }
            }
            if(!flag) break;
            ans++;
        }
        System.out.println(ans);
    }
    static boolean bfs(int y,int x){

        Queue<int[]> q= new ArrayDeque<>();
        Queue<int[]> resultQ = new ArrayDeque<>();
        boolean isUnion = false;
        resultQ.offer(new int[]{y,x});
        q.offer(new int[]{y,x,map[y][x]});
        int sum = map[y][x];
        int cnt = 1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int pop = c[2];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(visited[ni][nj]) continue;
                int diff = Math.abs(pop - map[ni][nj]);
                if(L<=diff && diff<=R){
                    isUnion = true;
                    visited[ni][nj] = true;
                    cnt++;
                    sum += map[ni][nj];
                    q.offer(new int[]{ni,nj,map[ni][nj]});
                    resultQ.offer(new int[]{ni,nj});
                }
            }
        }

        if(isUnion){
            int total = sum / cnt;
            while(!resultQ.isEmpty()){
                int[]c = resultQ.poll();
                int i = c[0]; int j = c[1];
                map[i][j] =total;
            }
        }
        return isUnion;
    }
}
