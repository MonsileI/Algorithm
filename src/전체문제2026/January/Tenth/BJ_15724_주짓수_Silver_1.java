package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_15724_주짓수_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<M+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int j=1;j<M+1;j++){
            for(int i=1;i<N+1;i++) {
                map[i][j] += map[i][j - 1];
            }
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++) {
                map[i][j] += map[i - 1][j];
            }
        }

        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken());
            int fj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            int result = map[si][sj] - (map[fi-1][sj] + map[si][fj-1]) + map[fi-1][fj-1];
            sb.append(result+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
