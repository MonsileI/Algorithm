package 전체문제.third_month_2024_02.sixth_2024_02_13;
import java.util.*;
import java.io.*;
public class BJ_11052_카드구매하기_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]w = new int[N+1];
        int[]v = new int[N+1];
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            w[i] = i;
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                dp[i][j] = dp[i-1][j];
                if(w[i]<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
