package 전체문제2025.September.Eighth;

import java.util.*;
import java.io.*;
public class BJ_2110_공유기설치_Gold_4 {
    static int N,M;
    static int[]Arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new int[N];
        for(int i=0;i<N;i++){
            Arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Arr);
        int L = 0 ; int R = Arr[N-1] - Arr[0];
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid) < M) R = mid;
            else L = mid+1;
        }
        System.out.println(L);
    }
    static int check(int mid){
        int before = Arr[0];
        int cnt = 1;
        for(int i=1;i<N;i++){
            int cur = Arr[i];
            if(cur - before > mid){
                cnt++;
                before = Arr[i];

            }
        }
        return cnt;
    }
}
