package 전체문제2026.January.Seventh;

import java.util.*;
import java.io.*;
public class BJ_11559_PuyoPuyo_Gold_4 {
    static char[][]map;
    static int N,M;
    static boolean[][]visited;
    static int[][]move ={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 12; M = 6;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        int cnt = 0;
        while(true){
            visited = new boolean[N][M];
            boolean flag = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j]!='.'){
                        visited[i][j] = true;
                        if(bfs(i,j,map[i][j])){
                            flag = true;
                        }
                    }
                }
            }
            if(!flag) break;
            // 중력 이동
            for(int i=N-1;-1<i;i--){
                for(int j=0;j<M;j++){
                        if(map[i][j]!='.' && i!=N-1){
                            int ci = i+1;
                            while(true){
                                 if(N==ci){
                                     ci--;break;
                                 }
                                 if(map[ci][j]!='.') {
                                     ci--; break;
                                 }
                                if(map[ci][j]=='.') ci++;
                            }
                            char tmp = map[ci][j];
                            map[ci][j] = map[i][j];
                            map[i][j] = tmp;
                        }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
    static boolean bfs(int y,int x,char shape){
        Queue<int[]> q= new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        q.offer(new int[]{y,x});
        list.add(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj] || map[ni][nj]!=shape) continue;
                visited[ni][nj] = true;
                list.add(new int[]{ni,nj});
                q.offer(new int[]{ni,nj});
            }
        }
        boolean flag = false;
        if(3 < list.size()){
            flag = true;
            for(int[] node : list){
                map[node[0]][node[1]] = '.';
            }
        }
        return flag;
    }
}
