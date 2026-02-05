package 전체문제2026.February.Third;

import java.util.*;
import java.io.*;
public class BJ_2073_수도배관공사_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int D = Integer.parseInt(st.nextToken()); //목표값
        int P = Integer.parseInt(st.nextToken()); //개수
        int[][]arr = new int[P][2];
        for(int i=0;i<P;i++){
            st= new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[]dp = new int[D+1];
        dp[0] = Integer.MAX_VALUE;
        for(int i=0;i<P;i++){
            for(int j=D;arr[i][0]<=j;j--){
                dp[j] = Math.max(dp[j],Math.min(dp[j-arr[i][0]],arr[i][1]));
            }
        }
        System.out.println(dp[D]);

    }
}
