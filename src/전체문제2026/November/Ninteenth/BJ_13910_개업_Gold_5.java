package 전체문제2026.November.Ninteenth;

import java.util.*;
import java.io.*;
public class BJ_13910_개업_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 음식 개수
        int M = Integer.parseInt(st.nextToken()); // 웍의 개수
        int[]wok = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) wok[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N+1];
        int INF = 987654321;
        Arrays.fill(dp,INF);
        dp[0] = 0;
        for(int i=0;i<M;i++){
            int fw = wok[i];
            if(N<fw) continue;
            for(int j=i+1;j<M;j++){
                int sw = wok[j];
                for(int l=0;l<=N;l++){
                    if(fw<=l && dp[l-fw]!=INF) dp[l] = Math.min(dp[l],dp[l-fw]+1); //하나씩
                    if(sw<=l && dp[l-sw]!=INF) dp[l] = Math.min(dp[l],dp[l-sw]+1); //하나씩
                    if((fw+sw)<=l && dp[l-fw-sw]!=INF) dp[l] = Math.min(dp[l],dp[l-fw-sw]+1); //양손
                }
            }
        }
        System.out.println(dp[N]==INF ? -1 : dp[N]);
    }
}
