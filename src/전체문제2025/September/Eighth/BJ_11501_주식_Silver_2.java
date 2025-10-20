package 전체문제2025.September.Eighth;

import java.util.*;
import java.io.*;
public class BJ_11501_주식_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(0<TC){
            TC--;
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cost = arr[N-1];
            long answer = 0;
            for(int i=N-2;-1<i;i--){
                if(cost > arr[i]){
                    answer += (cost - arr[i]);
                }else{
                    cost = arr[i];
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
