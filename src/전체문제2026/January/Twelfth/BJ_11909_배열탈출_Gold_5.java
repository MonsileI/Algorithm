package 전체문제2026.January.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_11909_배열탈출_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][]dp = new int[N][N];
        for(int i=1;i<N;i++){
            if(map[i][0] >= map[i-1][0]){
                dp[i][0] = dp[i-1][0] + ((map[i][0]-map[i-1][0])+1);
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int j=1;j<N;j++){
            if(map[0][j] >= map[0][j-1]){
                dp[0][j] = dp[0][j-1] + ((map[0][j]-map[0][j-1])+1);
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                //위쪽
                int upPoint = 0;
                if(map[i-1][j] <= map[i][j]) upPoint = (map[i][j] - map[i-1][j]) + 1;
                //왼쪽
                int downPoint = 0;
                if(map[i][j-1] <= map[i][j]) downPoint = (map[i][j] - map[i][j-1]) + 1;
                dp[i][j] = Math.min(dp[i-1][j]+upPoint,dp[i][j-1]+downPoint);
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
