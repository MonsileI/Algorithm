package 전체문제2026.July.August.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_6730_장애물경주난이도_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            int leftMax = 0; int rightMax = 0;
            for(int i=0;i<N-1;i++){
                leftMax = Math.max(leftMax,arr[i+1] - arr[i]);
                rightMax = Math.max(rightMax,arr[i] - arr[i+1]);
            }
            sb.append("#"+t+" "+leftMax+" "+rightMax+"\n");
        }
        System.out.println(sb.toString());
    }
}
