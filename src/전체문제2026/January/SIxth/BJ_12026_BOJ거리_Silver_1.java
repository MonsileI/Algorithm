package 전체문제2026.January.SIxth;

import java.util.*;
import java.io.*;
public class BJ_12026_BOJ거리_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int INF = 987654321;
        int[]dp = new int[N];
        Arrays.fill(dp,INF);
        dp[0] = 0;
        for(int i=1;i<N;i++){
            char cur = str.charAt(i);
            for(int j=0;j<i;j++){
                char before = str.charAt(j);
                if(checkOrder(before,cur)){
                    dp[i] = Math.min(dp[i],dp[j] + (int)Math.pow((j-i),2));
                }
            }
        }
        int answer = dp[N-1] == INF ? -1 : dp[N-1];
        System.out.println(answer);

    }
    static boolean checkOrder(char b,char a){
        if(b=='B' && a=='O') return true;
        if(b=='O' && a=='J') return true;
        if(b=='J' && a=='B') return true;
        return false;
    }
}
