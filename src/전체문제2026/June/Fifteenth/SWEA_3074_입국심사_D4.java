package 전체문제2026.June.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_3074_입국심사_D4 {
    static int[]arr;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            int max = 0;
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(br.readLine());
                max = Math.max(max,arr[i]);
            }
            long L = 0; long R = (long)max*M;
            while(L<R){
                long mid = (L+R)/2;
                if(calc(mid)) R = mid;
                else L = mid+1;
            }
            sb.append("#"+t+" "+L+"\n");

        }
        System.out.println(sb.toString());
    }
    static boolean calc(long mid){
        long people = 0;
        for(int i=0;i<N;i++){
            people += (mid/arr[i]);
            if(people>=M) return true;
        }

        return false;
    }
}
