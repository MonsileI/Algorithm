package 전체문제.ninth_month_2024_10.first_2024_10_29;

import java.util.*;
import java.io.*;
public class BJ_2178_미로탐색_Silver_1 {
    static int N,M;
    static int[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        System.out.println(bfs());
        br.close();

    }
    static int bfs(){
        Queue<int[]> q=  new ArrayDeque<>();
        q.offer(new int[]{0,0,1});

        visited[0][0] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2];
            if(i==N-1 && j==M-1){
                return cnt;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]==1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }

        return -1;
    }
}
