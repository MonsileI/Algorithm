package 전체문제.sixth_month_2024_05.fourteenth_2024_05_21;

import java.util.*;
import java.io.*;
public class BJ_11562_백양로브레이크_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1];
        int INF = 987654321;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i!=j)map[i][j] = INF;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[a][b] = 0;
            if(w==1) map[b][a] = 0;
            else map[b][a] = 1;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if (map[i][j] > map[i][l] + map[l][j]) {
                        map[i][j] = map[i][l] + map[l][j];
                    }
                }
            }
        }
        StringBuilder sb=  new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(map[a][b]+"\n");
        }
        System.out.println(sb.toString());
    }
}
