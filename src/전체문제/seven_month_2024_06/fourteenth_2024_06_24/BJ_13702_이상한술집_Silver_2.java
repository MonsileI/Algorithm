package 전체문제.seven_month_2024_06.fourteenth_2024_06_24;

import java.util.*;
import java.io.*;
public class BJ_13702_이상한술집_Silver_2 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        long L = 1; long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(arr[i],R);
        }
        while(L<=R){
            long mid = (L+R)/2;
            if(check(mid)<M) R = mid-1;
            else L = mid+1;
        }
        System.out.println(R);
    }
    static long check(long mid){
        long cnt = 0;
        for(int i=0;i<N;i++) {
            cnt += (arr[i]/mid);
        }
        return cnt;
    }
}
