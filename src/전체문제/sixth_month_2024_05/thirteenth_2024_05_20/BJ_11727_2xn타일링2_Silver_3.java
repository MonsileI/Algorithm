package 전체문제.sixth_month_2024_05.thirteenth_2024_05_20;

import java.util.*;
import java.io.*;
public class BJ_11727_2xn타일링2_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        dp[1] = 1;
        if(N==1) System.out.println(1);
        else{
            dp[2] = 3;
            for(int i=3;i<N+1;i++){
                dp[i] = (dp[i-1]%10007)+(2*dp[i-2])%10007;
            }
            System.out.println(dp[N]%10007);
        }
    }
}
