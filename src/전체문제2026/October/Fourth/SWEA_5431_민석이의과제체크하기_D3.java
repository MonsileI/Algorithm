package 전체문제2026.October.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_5431_민석이의과제체크하기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb =new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[]check = new boolean[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<K;i++){
                int num = Integer.parseInt(st.nextToken());
                check[num] = true;
            }
            sb.append("#"+t+" ");
            for(int i=1;i<=N;i++){
                if(!check[i]) sb.append(i+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
