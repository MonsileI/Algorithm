package 전체문제2026.January.Eighth;

import java.util.*;
import java.io.*;
public class BJ_11660_구간합구하기5_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<N+1;i++){
            for(int j=2;j<N+1;j++){
                map[i][j] += map[i][j-1];
            }
        }
        for(int j=1;j<N+1;j++){
            for(int i=2;i<N+1;i++){
                map[i][j] += map[i-1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<M;t++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken())-1;
            int fj = Integer.parseInt(st.nextToken())-1;
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            int ans = (map[si][sj] + map[fi][fj]) - (map[fi][sj] + map[si][fj]);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
