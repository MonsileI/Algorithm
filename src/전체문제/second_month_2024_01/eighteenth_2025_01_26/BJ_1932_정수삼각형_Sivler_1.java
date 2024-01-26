package 전체문제.second_month_2024_01.eighteenth_2025_01_26;
import java.util.*;
import java.io.*;
public class BJ_1932_정수삼각형_Sivler_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(map[i],987654321);
        StringTokenizer st= null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int idx = 0;
            for(int j=i;-1<j;j--){
                map[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }
        int[][]dp = new int[N][N];
        dp[0][0] = map[0][0];
        //바로 아래 아니면 오른쪽
        for(int i=1;i<N;i++){

            int j = 0;
            InnerLoop:
            for(j=0;j<N;j++){
                if(j==0) dp[i][j] = dp[i-1][j] + map[i][j];
                else if(map[i][j]==987654321) break InnerLoop;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+map[i][j];
            }
            j--;
            dp[i][j] = dp[i-1][j-1] + map[i][j];
        }
        int ans = 0;
        for(int i=0;i<N;i++) ans = Math.max(ans,dp[N-1][i]);
        System.out.println(ans);
    }
}
