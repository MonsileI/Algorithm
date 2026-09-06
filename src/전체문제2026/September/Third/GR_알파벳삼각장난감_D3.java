package 전체문제2026.September.Third;

import java.util.*;
import java.io.*;
public class GR_알파벳삼각장난감_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][];
        int[][]dp = new int[N][];
        for(int i=0;i<N;i++){
            arr[i] = new int[(i+1)];
            dp[i] = new int[(i+1)];
        }
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<i+1;j++){
                arr[i][j] = (str.charAt(j) - 'A') + 1;
            }
        }
        dp[0][0] = arr[0][0];
        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                //자기 자신 or -1
                if(j==0) dp[i][j] = dp[i-1][j];
                else if(j==i) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]);
                dp[i][j] += arr[i][j];
            }
        }
        int answer = 0;
        for(int j=0;j<N;j++) answer = Math.max(answer,dp[N-1][j]);
        System.out.println(answer);

    }
}
