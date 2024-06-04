package 전체문제.seven_month_2024_06.second_2024_06_04;

import java.util.*;
import java.io.*;
public class BJ_20181_꿈틀꿈틀호석애벌레_효율성_Gold_2  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        long[]dp = new long[N+1];
        long sum = arr[0]; int L=0; int R = 1;
        while(R<=N){
            if(sum>=K){
                while(sum>=K){
                    dp[R] = Math.max(dp[R],dp[L]+sum-K);
                    sum -= arr[L++];
                }
            }else{
                dp[R] = Math.max(dp[R],dp[R-1]);
                if(R==N) break;
                sum += arr[R++];
            }
        }

        //L = 2; R = 4; sum = 8;  dp[3] = 3;
        System.out.println(dp[N]);
    }
}

