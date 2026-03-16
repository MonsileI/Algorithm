package 전체문제2026.March.Tenth;

import java.util.*;
import java.io.*;
public class BJ_2110_공유기설치_Gold_4 {
    static int N;
    static int []arr;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int L = 0; int R = (arr[N-1] - arr[0]);
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)< M) R = mid;
            else L = mid+1;
        }
        System.out.println(L);
    }
    static int check(int mid){
        int cnt = 1;
        int before = arr[0];
        for(int i=1;i<N;i++){
            if(mid < arr[i] - before){
                cnt++;
                before = arr[i];
            }
        }
        return cnt;
    }
}
