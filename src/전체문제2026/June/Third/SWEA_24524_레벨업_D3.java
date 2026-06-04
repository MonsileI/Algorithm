package 전체문제2026.June.Third;

import java.util.*;
import java.io.*;
public class SWEA_24524_레벨업_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[]arr = new int[N];
            int sum  =0;
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(i==0) continue;
                sum += Math.abs(arr[i]-arr[i-1]);
            }
            int min = 0;
            for(int i=0;i<N-2;i++){
                int fir = Math.abs(arr[i]-arr[i+1]) + Math.abs(arr[i+1]-arr[i+2]);
                int sec = Math.abs(arr[i]-arr[i+2]);
                min = Math.min(min,(sec - fir));
            }
            sb.append((sum+min)+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}