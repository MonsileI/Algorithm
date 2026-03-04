package 전체문제2026.March.First;

import java.util.*;
import java.io.*;
public class BJ_3079_입국심사_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        int MAX = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(MAX,arr[i]);
        }
        long L = 0; long R = (long)MAX*M;
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid,arr,M)<M){
                L = mid+1;
            }else{
                R = mid;
            }
        }
        System.out.println(L);
    }
    static long check(long mid,int[]arr,long M){
        long cnt = 0;
        for(int i=0;i<arr.length;i++){
            cnt += (mid/arr[i]);
            if(cnt >= M) return cnt;
        }
        return cnt;
    }
}
