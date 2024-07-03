package DP.knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_13902_개업2_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int G = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        Set<Integer> set = new HashSet<>();
        int[]dp = new int[G+1];
        Arrays.fill(dp,987654321);
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]<G) {
                dp[arr[i]] = 1;
                set.add(arr[i]);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int sum = arr[i] + arr[j];
                if(sum>G) continue;
                set.add(sum);
                dp[sum] = 1;
            }
        }
        N = set.size();
        for(int value : set){
            for(int j=0;j<G+1;j++){
                if(value<=j){
                    dp[j] = Math.min(dp[j],dp[j-value]+1);
                }
            }
        }
        System.out.println(dp[G]==987654321 ? -1 : dp[G]);
    }
}
