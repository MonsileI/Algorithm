package DP;

import java.util.Arrays;

public class PR_거스름돈_Level_2 {

    static int solution(int n, int[] money) {
        int answer = 0;
        int mod = 1000000007;
        int len = money.length;
        int[][]dp = new int[len+1][n+1];
        for(int i=0;i<len+1;i++)dp[i][0] = 1;
        for(int i=1;i<len+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = dp[i-1][j] % mod;
                if(money[i-1]<=j){
                    dp[i][j] += (dp[i][j-money[i-1]]);
                }
            }
        }
        answer = dp[len][n]%mod;
        System.out.println(Arrays.deepToString(dp));
        return answer;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        int n = 5;
        int [] money = {1,2,5};

        int result = 4;
        * */
        int n = 5;
        int [] money = {1,2,5};
        System.out.println(solution(n,money));
    }
}
