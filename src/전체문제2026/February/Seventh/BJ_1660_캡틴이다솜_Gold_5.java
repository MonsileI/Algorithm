package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_1660_캡틴이다솜_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.println(1);
            System.exit(0);
        }
        List<Integer>list = new ArrayList<>();
        int num = 3;
        int cnt = 3;
        list.add(0);
        list.add(1);
        list.add(4);
        for(int i=3;i<N+1;i++) {
            int cur = list.get(i-1)+(num+cnt);
            if(N<cur){
                break;
            }
            list.add(cur);
            num += cnt;
            cnt++;
        }
        int size = list.size();
        int[][]dp = new int[size][N+1];
        int MAX = Integer.MAX_VALUE;
        for(int i=0;i<size;i++) Arrays.fill(dp[i],MAX);
        dp[0][0] = 0;
        for(int i=1;i<size;i++){
            int node = list.get(i);
            for(int j=0;j<N+1;j++){
                dp[i][j] = dp[i-1][j];
                if(node<=j){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-node]+1);
                }
            }
        }
        System.out.println(dp[size-1][N]);
    }
}
