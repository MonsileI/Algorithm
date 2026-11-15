package 전체문제2026.November.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_11446_사탕가방_D4 {
    static long []arr;
    static long M;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
             N = Integer.parseInt(st.nextToken());
             M = Long.parseLong(st.nextToken());
            arr = new long[N];
            st = new StringTokenizer(br.readLine()," ");
            long max = 0;
            for(int i=0;i<N;i++){
                arr[i] = Long.parseLong(st.nextToken());
                max = Math.max(max,arr[i]);
            }
            long L = 1; long R = max + 1;
            while(L<R){
                long mid = (L+R) / 2;
                if(M<=calc(mid)) L = mid+1;
                else R = mid;
            }
            sb.append("#"+t+" "+(L-1)+"\n");
        }
        System.out.println(sb.toString());
    }
    static long calc(long mid){
        long sum = 0;
        for(long i : arr){
            sum += i / mid;
        }
        return sum;
    }
}
