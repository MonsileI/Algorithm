package DP;

import java.util.Arrays;
public class PR_에어컨_Level_3 {


    static int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        int temp = temperature > t2 ? t1 - (temperature - t2) : temperature;
        t1 -= temp; t2 -= temp;
        temp = 0;

        int[][]dp = new int[onboard.length][t2+2];
        for(int i=0;i<onboard.length;i++) Arrays.fill(dp[i],987654321);
        dp[0][0] =0;
        for(int i=1;i<onboard.length;i++) {
            for(int j=0;j<t2+1;j++){
                if(onboard[i]==1 && (j<t1 || j>t2)) continue;
                int min = 987654321;
                if(j==0){
                    min = Math.min(min,dp[i-1][j]);
                    if(j+1<=t2+1) min = Math.min(min,dp[i-1][j+1]);
                }else{
                    if(j-1>=0) min = Math.min(min,dp[i-1][j-1]+a);
                    min = Math.min(min,dp[i-1][j]+b);
                    if(j+1<=t2+1) min = Math.min(min,dp[i-1][j+1]);
                }
                dp[i][j] = min;
            }
        }
        int result = 987654321;

        for(int i=0;i<=t2+1;i++){
            result = Math.min(result,dp[onboard.length-1][i]);
        }
        return result;
    }


    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int temperature = 28; int t1 = 18; int t2 = 26; int a = 10; int b =8;
        int [] onboard = {0, 0, 1, 1, 1, 1, 1};
        int result = 40;

        2.
        int temperature = -10; int t1 = -5; int t2 = 5; int a = 5; int b =1;
        int [] onboard = {0, 0, 0, 0, 0, 1, 0};
        int result = 25;

        3.
        int temperature = 11; int t1 = 8; int t2 = 10; int a = 10; int b =1;
        int [] onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1};
        int result = 20;

        4.
        int temperature = 11; int t1 = 8; int t2 = 10; int a = 10; int b =100;
        int [] onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1};
        int result = 60;
        * */
        int temperature = 11; int t1 = 8; int t2 = 10; int a = 10; int b =100;
        int [] onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1};
        System.out.println(solution(temperature,t1,t2,a,b,onboard));
    }
}
