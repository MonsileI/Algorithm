package 전체문제2026.October.Second;

import java.util.*;
import java.io.*;
public class SWEA_4831_전기버스_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[]subway = new boolean[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                int num = Integer.parseInt(st.nextToken());
                subway[num] = true;
           }
           int cnt = 0;
           int idx = N;
           while(K<idx){

               int tIdx = -1;
               for(int i=idx-K;i<idx;i++){
                   if(subway[i]){
                       cnt++;
                       tIdx = i;
                       break;
                   }
               }
               if(tIdx==-1) {
                   cnt = 0;
                   break;
               }
               idx = tIdx;
           }
           sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.println(sb.toString());

    }
}
