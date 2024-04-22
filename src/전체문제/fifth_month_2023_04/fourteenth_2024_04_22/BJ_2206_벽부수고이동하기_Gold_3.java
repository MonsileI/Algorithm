package 전체문제.fifth_month_2023_04.fourteenth_2024_04_22;

import java.util.*;
import java.io.*;
public class BJ_2206_벽부수고이동하기_Gold_3 {
    static int N,M;
    static int[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));
    }
    static int bfs(int si,int sj){
        boolean[][][]visited = new boolean[N][M][2];
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,1,0});
        visited[si][sj][0] = true;
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2]; int key = c[3];
            if(i==N-1&&j==M-1){
                return cnt;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==0){
                    if(!visited[ni][nj][key]){
                        visited[ni][nj][key] = true;
                        q.offer(new int[]{ni,nj,cnt+1,key});
                    }
                }else{
                    if(key==0 && !visited[ni][nj][key]){
                        visited[ni][nj][key] = true;
                        q.offer(new int[]{ni,nj,cnt+1,key+1});
                    }
                }

            }
        }


        return -1;
    }
}
