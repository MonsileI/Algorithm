package 전체문제2026.August.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_6485_삼성시의버스노선_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int maxBusLine = 5002;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[]sumArr = new int[maxBusLine];
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sumArr[s]++;
                sumArr[e+1]--;
            }
            for(int i=1;i<maxBusLine;i++) sumArr[i] += sumArr[i-1];
            int P = Integer.parseInt(br.readLine());
            sb.append("#"+t+" ");
            for(int i=0;i<P;i++){
                int l = Integer.parseInt(br.readLine());
                sb.append(sumArr[l]);
                if(i==P-1) break;
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
