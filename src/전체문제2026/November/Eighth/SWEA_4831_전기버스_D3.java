package 전체문제2026.November.Eighth;

import java.util.*;
import java.io.*;
public class SWEA_4831_전기버스_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[]arr = new int[M+1];
            st = new StringTokenizer(br.readLine()," ");
            boolean isPass = true;
            for(int i=1;i<=M;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(K < arr[i]-arr[i-1]) isPass = false;
            }
            int answer = 0;
            if(isPass) {
                int before = 0;
                for(int i=1;i<=M;i++){
                    if(K<arr[i] - before){
                        answer++;
                        before = arr[i-1];
                    }
                }
                if(K< N - before){
                    answer++;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
