package 전체문제.ninth_month_2024_10.first_2024_10_29;

import java.util.*;
import java.io.*;
public class BJ_11053_가장긴증가하는부분수열_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N];
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i=1;i<N;i++){
            int tmp = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
