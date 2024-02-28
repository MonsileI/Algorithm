package 전체문제.third_month_2024_02.eighteenth_2024_02_28;


import java.util.*;
import java.io.*;
public class BJ_2110_공유기설치_Gold_4 {
    static int N,C;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int L = 0; int R = 0;
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        R = arr[N-1] - arr[0] + 1;
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)<C) R = mid;
            else L = mid+1;
        }
        System.out.println(L);
    }
    static int check(int mid){
        int tmp = 1;
        int end = arr[0];
        for(int i=1;i<N;i++){
            if(arr[i]-end>mid){
                tmp++;
                end = arr[i];
            }
        }
        return tmp;
    }
}

