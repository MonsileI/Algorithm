package 전체문제2026.August.Third;

import java.util.*;
import java.io.*;
public class SWEA_7333_한솔이의택배아르바이트_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            int L = 0;
            int R = N-1;
            int cnt = 1;
            int answer = 0;
            while(L<=R){
                if(50 <= (arr[R]*cnt)) {
                    R--;
                    cnt = 1;
                    answer++;
                }else{
                    cnt++;
                    L++;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
