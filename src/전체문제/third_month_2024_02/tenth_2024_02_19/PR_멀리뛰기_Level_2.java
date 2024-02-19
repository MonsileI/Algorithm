package 전체문제.third_month_2024_02.tenth_2024_02_19;

public class PR_멀리뛰기_Level_2 {

    static long solution(int n) {
        int[]dp = new int[n+1];
        int mod = 1234567;
        dp[0] = 0;
        dp[1] = 1;
        if(n==1) return 1;
        dp[2] = 2;
        for(int i=3;i<n+1;i++) dp[i] = (dp[i-1] + dp[i-2])%mod;
        return (dp[n]%mod);
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int n = 4;

        long result =5;

        2.
        int n = 3;

        long result = 3;
        * */
        int n =4;
        System.out.println(solution(n));

    }
}
