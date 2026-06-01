package 전체문제2026.June.First;

import java.util.*;
import java.io.*;
public class SWEA_1249_보급로_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]map = new int[N][N];
            int[][]dist = new int[N][N];
            for(int i=0;i<N;i++){
                String str = br.readLine();
                Arrays.fill(dist[i],987654321);
                for(int j=0;j<N;j++){
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            dist[0][0] = 0;
            Queue<int[]> q= new ArrayDeque<>();
            q.offer(new int[]{0,0,0});
            int answer = Integer.MAX_VALUE;
            while(!q.isEmpty()){
                int[]c = q.poll();
                int i = c[0]; int j =c[1]; int cnt = c[2];
                if(i==N-1&&j==N-1){
                    answer = Math.min(answer,cnt);
                    continue;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(dist[ni][nj] > map[ni][nj] + cnt){
                        dist[ni][nj] = map[ni][nj] + cnt;
                        q.offer(new int[]{ni,nj,dist[ni][nj]});
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
