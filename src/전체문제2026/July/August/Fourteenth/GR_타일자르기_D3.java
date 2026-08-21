package 전체문제2026.July.August.Fourteenth;

import java.util.*;
import java.io.*;
public class GR_타일자르기_D3 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int L = 1; int R = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R,arr[i]);
        }
        R++;
        while(L<R){
            int mid = (L+R)/2;
            if(calc(mid) < M) R = mid;
            else L = mid+1;
        }
        System.out.println(L-1);
    }
    static int calc(int mid){
        int cnt = 0;
        for(int i=0;i<N;i++){
            cnt += arr[i]/mid;
        }
        return cnt;
    }
}
