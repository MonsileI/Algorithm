package 전체문제2026.January.Seventh;

import java.util.*;
import java.io.*;
public class BJ_1495_기타리스트_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //곡의 개수
        int S = Integer.parseInt(st.nextToken()); //처음 사운드
        int M = Integer.parseInt(st.nextToken()); //사운드 최댓값 (0<= 볼륨 <=M)
        int[]song = new int[N+1];
        song[0] = S;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) song[i] = Integer.parseInt(st.nextToken());
        boolean[][]dp = new boolean[N+1][M+1];
        dp[0][S] = true;
        for(int i=1;i<N+1;i++){
            int p = song[i];
            for(int j=0;j<M+1;j++){
                if(dp[i-1][j]){
                    if(j+p<M+1) dp[i][j+p] = true;
                    if(-1<j-p) dp[i][j-p] = true;
                }
            }
        }
        int answer = -1;
        for(int i=M;-1<i;i--){
            if(dp[N][i]){
                answer = i;
                break;
            }
        }
        System.out.println(answer);


    }
}
