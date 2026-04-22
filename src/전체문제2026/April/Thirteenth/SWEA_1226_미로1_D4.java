package 전체문제2026.April.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1226_미로1_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = 10;
        int N = 16;
        int[][]map;
        boolean[][]visited;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        while(0<TC){
            int t = Integer.parseInt(br.readLine());
            int si = 0; int sj = 0;
            int ei = 0; int ej = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(str.charAt(j)+"");
                    if(map[i][j]==2) {
                        si = i; sj = j;
                    }
                    if(map[i][j]==3){
                        ei = i; ej = j;
                    }

                }
            }
            boolean isArrived = false;
            visited[si][sj] = true;
            Queue<int[]> q= new ArrayDeque<>();
            q.offer(new int[]{si,sj});
            while(!q.isEmpty()){
                int []c = q.poll();
                int i = c[0]; int j =c[1];
                if(i==ei && j==ej){
                    isArrived = true;
                    break;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(visited[ni][nj]) continue;
                    if(map[ni][nj]==1) continue;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
            sb.append("#"+t+" ");
            if(isArrived) sb.append(1);
            else sb.append(0);
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
