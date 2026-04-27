package 전체문제2026.April.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_19118_언덕길_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            int[]lis = new int[N];
            int answer = 1;
            for(int i=0;i<N;i++){
                lis[i] = 1;
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]){
                        lis[i] = Math.max(lis[i],lis[j]+1);
                    }
                }
                answer = Math.max(answer,lis[i]);
            }
            answer = N-answer;
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
