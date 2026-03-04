package 전체문제2026.March.First;

import java.util.*;
import java.io.*;
public class BJ_21922_학부연구생민상_Gold_5 {
    static int N,M;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map  =new int[N][M];
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][][]visited = new boolean[N][M][4];
        boolean[][]check = new boolean[N][M];
        int ans = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    for(int d=0;d<4;d++) {
                        q.offer(new int[]{i, j,d});
                        visited[i][j][d] = true;
                    }
                    map[i][j] = 0;
                    check[i][j] = true;
                    ans++;
                }
            }
        }
        //1 왼 -> 오, 오 -> 왼
        //2 위 -> 아래, 아래 -> 위
        //3 왼 -> 아래, 오른 -> 위 , 위->오른 아래 -> 왼 (0,1,2,3) -> (1,0,3,2)
        //4 왼 -> 위, 오른 ->아래 , 위 -> 왼 , 아래 -> 오른 (0,1,2,3) -> (3,2,1,0)
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i  =c[0]; int j =c[1]; int d= c[2];
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(!check[ni][nj]){
                check[ni][nj] = true;
                ans++;
            }
            if(map[ni][nj]==0){
                if(!visited[ni][nj][d]){
                    visited[ni][nj][d] = true;
                    q.offer(new int[]{ni,nj,d});
                }
            }
            if(map[ni][nj]==1){
                if(d==1 || d==3){
                    d = d == 1 ? 3 : 1;
                }
            }
            if(map[ni][nj]==2){
                if(d==0 || d==2){
                    d = d == 0 ? 2 : 0;
                }
            }
            if(map[ni][nj]==3){
                //1 0 3 2
                //0 1 2 3
                if(d%2==0){
                    d++;
                }else{
                    d--;
                }
            }
            if(map[ni][nj]==4){
                //3 2 1 0
                //0 1 2 3
                d = Math.abs(d-3);
            }
            if(!visited[ni][nj][d]){
                visited[ni][nj][d] = true;
                q.offer(new int[]{ni,nj,d});
            }
        }
        System.out.println(ans);
    }
}
