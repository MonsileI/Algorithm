package 전체문제2026.August.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_7730_나무깎는홍준_D5 {
    static int N;
    static int[]arr;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            int L = 0; int R = 0;
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                R = Math.max(R,arr[i]);
            }
            while(L<=R){
                int mid = (L+R)/2;
                if(calc(mid)) L = mid+1;
                else R = mid-1;
            }
            sb.append("#"+t+" "+R+"\n");

        }
        System.out.println(sb.toString());
    }
    static boolean calc(int mid){
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(mid<arr[i]) cnt += (arr[i]-mid);
            if(M<=cnt) return true;
        }
        return false;
    }
}