package 전체문제.Thirteen_2024_01_03;
import java.util.*;
import java.io.*;
public class bj_7570_줄세우기_Gold_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]dp = new int[N+1];
        int max = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            dp[num] = dp[num-1]+1;
            max = Math.max(max,dp[num]);
        }
        System.out.println(N-max);


    }
}
