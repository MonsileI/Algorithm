package 전체문제2025.September.Ninth;

import java.util.*;
import java.io.*;
public class BJ_18247_함께블록쌓기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        List<Integer>[] block = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            block[i] = new ArrayList<>();
            for(int j=0;j<M;j++){
                if(st.hasMoreElements() == false) break;
                int b = Integer.parseInt(st.nextToken());
                block[i].add(b);
            }
        }
        int[][]dp = new int[N+1][H+1];

        int answer = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<H+1;j++){
                for(int b : block[i]){
                    if(j==b) dp[i][j]++;
                    if(j>b){
                        dp[i][j] += dp[i-1][j-b];
                    }
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }
        answer = dp[N][H];
        System.out.println(answer);
    }
}
