package 전체문제.fourth_month_2024_03.sixteenth_2024_03_22;
import java.util.*;
import java.io.*;
public class BJ_17845_수강과목_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int G = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[]w = new int[N+1]; int[]v = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            v[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }
        int[][]dp = new int[N+1][G+1];
        for(int i=1;i<N+1;i++){
            for(int j=0;j<G+1;j++){
                dp[i][j] = dp[i-1][j];
                if(w[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[N][G]);
    }
}
