package 전체문제2026.August.Fourteenth;

import java.util.*;
import java.io.*;
public class GR_파테크_D3 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int L = 0; int R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }
        while(L<R){
            int mid = (L+R)/2;
            if(calc(mid)<M) R = mid;
            else L = mid+1;
        }
        System.out.println(L-1);
    }
    static long calc(int mid){
        long sum = 0;
        for(int i=0;i<N;i++){
            if(mid<arr[i]) {
                sum += arr[i] - mid;
            }
        }
        return sum;
    }
}
