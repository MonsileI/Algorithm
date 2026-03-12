package 전체문제2026.March.Sixth;

import java.util.*;
import java.io.*;
public class BJ_29703_펭귄의하루_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]map = new char[N][M];
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][][]visited= new boolean[N][M][2];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S'){
                    q.offer(new int[]{i,j,0,0});
                    visited[i][j][0] = true;
                    map[i][j] = 'E';
                }
            }
        }
        int answer = -1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int isFish = c[2]; int cnt = c[3];
            if(map[i][j]=='H' && isFish==1){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='D') continue;
                int tmpFish = map[ni][nj]=='F' ? 1 : isFish;
                if(visited[ni][nj][tmpFish]) continue;
                visited[ni][nj][tmpFish] = true;
                q.offer(new int[]{ni,nj,tmpFish,cnt+1});
            }
        }
        System.out.println(answer);
    }
}
