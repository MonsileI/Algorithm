package 전체문제2025.September.Third;

import java.util.Arrays;

public class PR_GPS_Level_3 {
    public static void main(String[]args) {
        int n =  7;
        int m = 10;
        int [][]edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
        int k = 6;
        int [] gps_log = {1, 2, 3, 3, 6, 7};
        //int answer = 1;
        System.out.println(solution(n,m,edge_list,k,gps_log));
    }

    static  int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        boolean[][]check = new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            int from = edge_list[i][0];
            int to = edge_list[i][1];
            check[from][to] = check[to][from] = true;
        }
        int[][]dp = new int[k][n+1];
        for(int i=0;i<k;i++) {
            Arrays.fill(dp[i],987654321);
        }
        dp[0][gps_log[0]] = 0;
        for(int i=1;i<k;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);

                for(int l=1;l<n+1;l++){
                    if(check[j][l]){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][l]);
                    }
                }
                if(j != gps_log[i]) dp[i][j]++;
            }
        }
        int answer = dp[k-1][gps_log[k-1]];
        return answer <= k ? answer : -1;
    }
}
