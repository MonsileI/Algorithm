package 전체문제2026.October.Tenth;

import java.util.*;

public class PR_코딩테스트공부_Level_3 {
    public static void main(String[] args) {
        int alp = 10;
        int cop = 10;
        int[][]problems = {{10,15,2,1,2}, {20,20,3,3,4}};
        System.out.println(solution(alp,cop,problems));
    }
    static int solution(int alp, int cop, int[][] problems) {
        int goalAlp = 0; int goalCop = 0;
        for(int []p : problems){
            goalAlp = Math.max(goalAlp,p[0]);
            goalCop = Math.max(goalCop,p[1]);
        }
        if(goalAlp<=alp) goalAlp = alp;
        if(goalCop<=cop) goalCop = cop;
        int[][]dp = new int[goalAlp+1][goalCop+1];
        int INF = 987654321;
        for(int i=0;i<=goalAlp;i++) Arrays.fill(dp[i],INF);
        dp[alp][cop] = 0;
        for(int i=alp;i<=goalAlp;i++){
            for(int j=cop;j<=goalCop;j++){
                if(i!=0){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                }
                if(j!=0){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                }
                for(int [] p : problems){
                    if(i < p[0] || j < p[1]) continue;
                    int nextAlp = Math.min(i+p[2],goalAlp);
                    int nextCop = Math.min(j+p[3],goalCop);
                    dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop],dp[i][j] + p[4]);
                }
            }
        }
        return dp[goalAlp][goalCop];
    }
}
