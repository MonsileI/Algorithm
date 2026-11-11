package 전체문제2026.November.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_10507_영어공부_D5 {
    static int N;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            int answer = 0;
            for(int idx=0;idx<N;idx++){
                int total = 1;
                int L = idx; int R = N-1;
                while(L<=R){
                    int mid = (L+R)/2;
                    int diffDay = (arr[mid] - arr[idx] + 1) - (mid - idx + 1);
                    if(diffDay<=M){
                        total = Math.max(total,(arr[mid] - arr[idx] + 1)+(M-diffDay)); //마지막 날
                        L = mid + 1;
                    }else{
                        R = mid - 1;
                    }
                }
                answer = Math.max(answer,total);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
