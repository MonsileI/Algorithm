package 전체문제2026.January.Ninth;
import java.util.*;
import java.io.*;
public class BJ_18353_병사배치하기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        int[]dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Arrays.fill(dp,1);
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = 1;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(N-max);
    }
}
