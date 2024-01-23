package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2573_빙산_Gold_4 {
    static int N,M,map[][];
    static Queue<int[]> ice;
    static  boolean[][] visited;
    static boolean[][]iceVisited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ice = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) {
                    ice.offer(new int[]{i,j});
                }
            }
        }
        int time = 0;
        while(true){
            if(check()) break;
            melt();
            time++;
            if(ice.isEmpty()) break;
        }
        if(ice.isEmpty()) System.out.println(0);
        else System.out.println(time);
    }

    static void melt(){
        int size = ice.size();
        List<int[]> erase = new ArrayList<>();
        for(int t=0;t<size;t++){
            int[]c = ice.poll();
            int i = c[0]; int j = c[1];
            int tmp = 0;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==0) tmp++;
            }
            int diff = map[i][j] - tmp;
            if(diff < 1){
                erase.add(new int[]{i,j});
            }else{
                map[i][j] -= tmp;
                ice.offer(new int[]{i,j});
            }
        }
        for(int[] c : erase) map[c[0]][c[1]] = 0;
    }
    static boolean check(){
        boolean flag = false;
        visited=  new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0&&!visited[i][j]){
                    if(flag) return true;
                    else{
                        flag = true;
                        bfs(i,j);
                    }
                }
            }
        }
        return false;
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i  =c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i +move[d][0]; int nj= j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj)continue;
                if(!visited[ni][nj]&&map[ni][nj]!=0){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
