package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_13910_개업_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int MAX = 10001;
        int[]wok = new int[MAX];
        wok[0] =1;
        for(int i=0;i<M;i++){
            wok[Integer.parseInt(st.nextToken())]++;
        }
        //왼손 오른손 turn씩
        int[]dp = new int[N+1];
        Arrays.fill(dp,MAX);
        for(int i=1;i<N+1;i++){
            for(int j=0;j<i/2+1;j++){
                // 1. 한 번에 만드는 경우
                if (j == i - j) {
                    if (wok[j] > 1) {
                        dp[i] = 1;
                    }
                } else {
                    if (wok[j] > 0 && wok[i - j] > 0) {
                        dp[i] = 1;
                    }
                }
                // 2. 나눠서 만드는 경우
                if (dp[j] != MAX && dp[i - j] != MAX) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        System.out.println(dp[N]==MAX ? -1 : dp[N]);
    }
}
