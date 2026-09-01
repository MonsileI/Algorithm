package 전체문제2026.August.Third;

import java.util.*;
import java.io.*;
public class SWEA_7088_은기의송아지세기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int Q  = Integer.parseInt(st.nextToken());
            int[][]sum = new int[N+1][4]; //세개밖에 없음
            for(int i=1;i<=N;i++){
                int num = Integer.parseInt(br.readLine());
                for(int j=1;j<4;j++){
                    sum[i][j] = sum[i-1][j];
                }
                sum[i][num]++;
            }
            sb.append("#"+t+"\n");
            for(int i=0;i<Q;i++){
                st = new StringTokenizer(br.readLine()," ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                for(int j=1;j<4;j++){
                    sb.append(sum[e][j] - sum[s-1][j]);
                    if(j==3) break;
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
