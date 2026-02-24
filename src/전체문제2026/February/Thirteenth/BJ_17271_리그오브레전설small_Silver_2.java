package 전체문제2026.February.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_17271_리그오브레전설small_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dp = new int[N+1];
        Arrays.fill(dp,1);
        int mod = 1000000007;
        for(int i=1;i<N+1;i++){
            if(M<=i){
                dp[i] = (dp[i-1]%mod) + (dp[i-M]%mod);
            }
        }
        System.out.println(dp[N]%mod);
    }
}
