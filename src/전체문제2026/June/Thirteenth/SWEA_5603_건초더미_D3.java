package 전체문제2026.June.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_5603_건초더미_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            int[]arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }
            sum /= N;
            int answer = 0;
            for(int i=0;i<N;i++){
                if(arr[i]<sum) answer += (sum-arr[i]);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
