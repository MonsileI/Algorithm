package 전체문제2026.January.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_2411_아이템먹기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int O = Integer.parseInt(st.nextToken());
        char[][]map = new char[N+1][M+1];
        int[][]dp = new int[N+1][M+1];
        int[][]item = new int[A+2][2];
        item[0][0] = N-1;
        item[0][1] = 1;
        for(int tc=1;tc<A+1;tc++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken());
            i = Math.abs(i-(N-1));
            item[tc][0] = i;
            item[tc][1] = j;
        }
        item[A+1][0] = 0; item[A+1][1] = M;
        for(int tc=0;tc<O;tc++){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken());
            i = Math.abs(i-(N-1));
            map[i][j] = 'O';
        }
        Arrays.sort(item, (a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0]; // i는 아래→위 (좌표 뒤집었기 때문)
        });
        int bi = item[0][0]; int bj = item[0][1];
        dp[bi][bj] = 1;
        for(int tc=0;tc<A+2;tc++){
            int ci = item[tc][0]; int cj = item[tc][1];
            for(int i=bi;ci<=i;i--){
                for(int j=bj;j<=cj;j++){
                    if(i==bi&&j==bj) continue;
                    if(map[i][j]=='O') continue;
                    dp[i][j] += dp[i+1][j];
                    dp[i][j] += dp[i][j-1];
                }
            }
            bi = ci; bj = cj;
        }
        System.out.println(dp[0][M]);
    }
}
