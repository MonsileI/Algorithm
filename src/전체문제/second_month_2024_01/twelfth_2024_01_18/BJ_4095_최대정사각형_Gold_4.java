package 전체문제.second_month_2024_01.twelfth_2024_01_18;
import java.util.*;
import java.io.*;
public class BJ_4095_최대정사각형_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            int M = Integer.parseInt(st.nextToken());
            int[][]map = new int[N+1][M+1];
            int[][]dp = new int[N+1][M+1];
            for(int i=1;i<N+1;i++){
               st = new StringTokenizer(br.readLine()," ");
               for(int j=1;j<M+1;j++){
                   map[i][j] = Integer.parseInt(st.nextToken());

               }
           }
            int max = 0;
            for(int i=1;i<N+1;i++){
                for(int j=1;j<M+1;j++){
                    if(map[i][j]==1){
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
            sb.append(max+"\n");
        }
        System.out.println(sb.toString());
    }
}
