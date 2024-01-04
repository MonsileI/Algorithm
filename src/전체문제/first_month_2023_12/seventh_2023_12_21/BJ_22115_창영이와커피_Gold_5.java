package 전체문제.first_month_2023_12.seventh_2023_12_21;
import java.util.*;
import java.io.*;
public class BJ_22115_창영이와커피_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr =new int[N+1];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[][]dp = new int[N+1][M+1];
        int INF = 987654321;
        for(int i=0;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++){
            int caf = arr[i];
            for(int j=0;j<M+1;j++){
                dp[i][j] = dp[i-1][j];
                if(caf<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-caf]+1);
                }
            }
        }
        System.out.println(dp[N][M]==INF ? -1 : dp[N][M]);
    }
}
