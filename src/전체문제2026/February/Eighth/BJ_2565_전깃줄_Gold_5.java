package 전체문제2026.February.Eighth;

import java.util.*;
import java.io.*;
public class BJ_2565_전깃줄_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr= new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2) -> o1[0] - o2[0]);
        int[]dp = new int[N];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j][1] < arr[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(N-max);
    }
}
