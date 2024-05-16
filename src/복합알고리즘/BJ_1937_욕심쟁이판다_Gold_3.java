package 복합알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1937_욕심쟁이판다_Gold_3 {
    static int N;
    static int [][]map;
    static int [][]dp;
    static int ans;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               ans = Math.max(ans,dfs(i,j));
            }
        }
        System.out.println(ans);
    }
    static int dfs(int i,int j){
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j] = 1;
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
            if(map[i][j]<map[ni][nj]){
                dp[i][j] = Math.max(dp[i][j],dfs(ni,nj)+1);
            }
        }
        return dp[i][j];
    }
}
