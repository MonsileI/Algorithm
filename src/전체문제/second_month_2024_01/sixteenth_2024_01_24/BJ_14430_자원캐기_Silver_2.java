package 전체문제.second_month_2024_01.sixteenth_2024_01_24;
import java.util.*;
import java.io.*;
public class BJ_14430_자원캐기_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<M+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][]dp = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]==1) dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[N][M]);
    }
}
