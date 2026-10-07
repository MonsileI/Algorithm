package 전체문제2026.October.Third;

import java.util.*;
import java.io.*;
public class SWEA_1227_미로2_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = 10;
        int N = 100;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        while(0<TC){
            int t = Integer.parseInt(br.readLine());
            int answer = 0;
            char[][]map = new char[N][N];
            int si =0 ;int sj = 0;
            int ei =0 ; int ej = 0;
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='2'){
                        si = i;
                        sj = j;
                        map[i][j] = '0';
                    }
                    if(map[i][j]=='3'){
                        ei = i;
                        ej = j;
                        map[i][j] = '0';
                    }
                }
            }
            Queue<int[]> q= new ArrayDeque<>();
            boolean[][]visited = new boolean[N][N];
            visited[si][sj] = true;
            q.offer(new int[]{si,sj});
            while(!q.isEmpty()){
                int[]c = q.poll();
                int i = c[0]; int j = c[1];
                if(i==ei && j==ej){
                    answer = 1;
                    break;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(map[ni][nj]=='1') continue;
                    if(visited[ni][nj]) continue;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }

            }
            sb.append("#"+t+" "+answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
