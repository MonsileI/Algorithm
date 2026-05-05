package 전체문제2026.May.First;

import java.util.*;
import java.io.*;
public class SWEA_1249_보급로_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]map = new int[N][N];
            int INF = 987654321;
            int[][]visited = new int[N][N];
            int answer = INF;
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(str.charAt(j)+"");
                    visited[i][j] = INF;
                }
            }
            visited[0][0] = 0;
            Queue<int[]> q=  new ArrayDeque<>();
            q.offer(new int[]{0,0,0});
            while(!q.isEmpty()){
                int[]c=  q.poll();
                int i = c[0];int j =c[1]; int cnt= c[2];
                if(answer<=cnt) continue;
                if(i==N-1&&j==N-1){
                    answer = cnt;
                    continue;
                }
                for(int d=0;d<4;d++){
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(visited[ni][nj] <= map[ni][nj] + cnt) continue;
                    visited[ni][nj] = map[ni][nj] + cnt;
                    q.offer(new int[]{ni,nj,map[ni][nj]+cnt});
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
