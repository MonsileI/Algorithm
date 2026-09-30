package 전체문제2026.September.Thirteenth;

import java.util.*;
import java.io.*;
public class GR_연결요소제거하기_D3 {
    static int N;
    static int K;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        for(int t=0;t<Q;t++){
            st = new StringTokenizer(br.readLine()," ");
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            char alpha = st.nextToken().charAt(0);
            map[y][x] = alpha;
            //t가 0일 때만 전체 요소 검사?
            visited=  new boolean[N][N];
            if(t==0){
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(!visited[i][j] && map[i][j]!='.'){
                            visited[i][j] = true;
                            bfs(i,j);
                        }
                    }
                }
                continue;
            }
            visited[y][x] = true;
            bfs(y,x);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(map[i][j]);
            }
            if(i==N-1) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){
        char alpha = map[y][x];
        Queue<int[]> q= new ArrayDeque<>();
        int cnt = 1;
        q.offer(new int[]{y,x});
        Queue<int[]> erazeQ = new ArrayDeque<>();
        erazeQ.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!rangeCheck(ni,nj)) continue;
                if(!visited[ni][nj] && map[ni][nj]==alpha){
                    visited[ni][nj] = true;
                    cnt++;
                    erazeQ.offer(new int[]{ni,nj});
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        if(K<=cnt){
            while(!erazeQ.isEmpty()){
                int[]c = erazeQ.poll();
                int i = c[0]; int j =c[1];
                map[i][j] = '.';
            }
        }
    }
    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||N-1<j) return false;
        return true;
    }
}
