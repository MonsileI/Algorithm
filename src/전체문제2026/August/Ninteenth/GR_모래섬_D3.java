package 전체문제2026.August.Ninteenth;

import java.util.*;
import java.io.*;
public class GR_모래섬_D3 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //0 = 물 1 = 모래 , 모래가 두 개 이상
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<int[]> water = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) water.offer(new int[]{i,j});
            }
        }
        int time = 0;
        while(true){
            //물 퍼뜨리기
            int qSize = water.size();
            for(int t=0;t<qSize;t++){
                int[]c = water.poll();
                int i = c[0]; int j = c[1];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(!rangeCheck(ni,nj)) continue;
                    if(map[ni][nj]==1){
                        map[ni][nj] = 0;
                        water.offer(new int[]{ni,nj});
                    }
                }
            }

            //모래 개수 세기
            int cnt = 0;
            boolean sendFlag = false;
            visited = new boolean[N][M];
            OuterLoop:
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1){
                        sendFlag = true;
                        if(!visited[i][j]){
                            visited[i][j] = true;
                            bfs(i, j);
                            cnt++;
                        }
                    }
                    if(1<cnt) break OuterLoop;
                }
            }
            time++;
            if(!sendFlag){
                time = -1;
                break;
            }
            if(1<cnt) break;
        }
        System.out.println(time);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];int j =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!rangeCheck(ni,nj)) continue;
                if(!visited[ni][nj] && map[ni][nj]==1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
}
