package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_2758_로또_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        long[][]dp = new long[11][2001];
        for(int j=1;j<2001;j++) dp[1][j] = j;
        for(int i=2;i<11;i++){
            for(int j=i;j<2001;j++){
                dp[i][j] += dp[i][j-1]+dp[i-1][j/2];
            }
        }
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(dp[N][M]+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
