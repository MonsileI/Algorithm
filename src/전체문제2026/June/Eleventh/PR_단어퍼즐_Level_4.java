package 전체문제2026.June.Eleventh;

import java.util.*;

public class PR_단어퍼즐_Level_4 {
    public static void main(String[] args) {
        String[]strs = {"ba","an","nan","ban","n"};
        String t = "banana";
        System.out.println(solution(strs,t));
    }
    static int solution(String[] strs, String t) {
        Set<Integer> strSize = new HashSet<>();
        int INF = 987654321;
        int N = t.length();
        int[]dp = new int[N+1];
        Arrays.fill(dp,INF);
        dp[0] = 0;
        for(String s : strs) strSize.add(s.length());
        for(int i=1;i<N+1;i++){
            for(int size : strSize){
                if(0<=i-size){
                    String sub = t.substring(i-size,i);
                    if(Arrays.asList(strSize).contains(sub)){
                        dp[i] = Math.min(dp[i],dp[i-size]+1);
                    }
                }
            }
        }
        int answer = dp[N]==INF ? -1 : dp[N];
        return answer;
    }
}
