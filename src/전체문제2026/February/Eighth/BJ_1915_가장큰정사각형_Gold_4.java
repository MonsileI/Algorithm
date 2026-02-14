package 전체문제2026.February.Eighth;
import java.util.*;
import java.io.*;
public class BJ_1915_가장큰정사각형_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][M+1];
        int[][]dp = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            String str =br.readLine();
            for(int j=1;j<M+1;j++){
                dp[i][j] = map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
            }
        }
        int maxNode = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]==0) continue;
                int diff = dp[i][j] = maxNode;
                if(dp[i-diff][j] == dp[i][j-diff] && dp[i][j-diff] == dp[i-diff][j-diff]){
                    dp[i][j]++;
                }
                maxNode = Math.max(maxNode,dp[i][j]);
            }
        }
        int max = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                max = Math.max(max,dp[i][j]);
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        long answer = max*max;
        System.out.println(answer);
    }
}
