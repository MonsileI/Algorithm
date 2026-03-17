package 전체문제2026.March.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1719_택배_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1];
        int INF = 987654321;
        int[][]answer = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            Arrays.fill(map[i],INF);
            map[i][i] = 0;
            for(int j=1;j<N+1;j++){
                answer[i][j] = j;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = w;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(map[i][j] > (map[i][l] + map[l][j])){
                        map[i][j] = (map[i][l] + map[l][j]);
                        answer[i][j] = answer[i][l];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j){
                    sb.append("-");
                }else {
                    sb.append(answer[i][j]);
                }
                if(j==N) sb.append("\n");
                else sb.append(" ");

            }
        }
        System.out.println(sb.toString());
    }
}
