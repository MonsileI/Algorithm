package 전체문제2026.September.Seventh;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GR_보드게임_D3 {
    static int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]dp = new int[N+1];
        int[]resetArr = {0,1,1,2};
        if(N<4){
            System.out.println(resetArr[N]);
        }else {
            for(int i=1;i<=3;i++) dp[i] = resetArr[i];
            for (int i = 4; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 3] ) % MOD;
            }
            System.out.println(dp[N]);
        }
    }
}
