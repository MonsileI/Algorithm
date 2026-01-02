package 전체문제2026.January.First;

import java.util.Arrays;

public class PR_스티커모으기2_Level_3 {
    public static void main(String[] args) {
        int[]sticker = {4, 3, 2, 9, 4};
        System.out.println(solution(sticker));
    }
    static int solution(int sticker[]) {
        int N = sticker.length;
        if(N==1) return sticker[0];
        if(N==2) return Math.max(sticker[0],sticker[1]);

        int[]dp = new int[N];
        dp[0] = sticker[0];
        for(int i=2;i<N-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+sticker[i]);
            if(i!=2){
                dp[i] = Math.max(dp[i],dp[i-3]+sticker[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        int answer = dp[N-2];
        dp = new int[N];
        dp[1] = sticker[1];
        for(int i=2;i<N;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+sticker[i]);
            if(i!=2){
                dp[i] = Math.max(dp[i],dp[i-3]+sticker[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        answer = Math.max(answer,dp[N-1]);
        return answer;
    }
}
