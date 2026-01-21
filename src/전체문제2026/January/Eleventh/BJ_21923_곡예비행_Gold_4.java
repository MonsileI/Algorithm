package 전체문제2026.January.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_21923_곡예비행_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][]upDp = new int[N][M];
        int[][]downDp = new int[N][M];
        upDp[N-1][0] = map[N-1][0];
        downDp[N-1][M-1] = map[N-1][M-1];
        for(int i=N-2;-1<i;i--){
            upDp[i][0] = upDp[i+1][0] + map[i][0];
            downDp[i][M-1] = downDp[i+1][M-1] + map[i][M-1];
        }
        upDp[N-1][M-1] = map[N-1][M-1];
        for(int j=1;j<M;j++) {
            upDp[N-1][j] = upDp[N-1][j-1] + map[N-1][j];
        }
        for(int j=M-2;-1<j;j--){
            downDp[N-1][j] = downDp[N-1][j+1] + map[N-1][j];
        }

        for(int i=N-2;-1<i;i--){
            for(int j=1;j<M;j++){
                upDp[i][j] = Math.max(upDp[i+1][j],upDp[i][j-1]) + map[i][j];
            }
        }
        for(int i=N-2;-1<i;i--){
            for(int j=M-2;-1<j;j--){
                downDp[i][j] = Math.max(downDp[i+1][j],downDp[i][j+1]) + map[i][j];
            }
        }

        int max = -100000000;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                max = Math.max(max,(upDp[i][j]+downDp[i][j]));
            }
        }

        System.out.println(max);
    }
}
