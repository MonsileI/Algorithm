package 전체문제2026.January.Ninth;
import java.util.*;
import java.io.*;
public class BJ_22869_징검다리건너기small_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N+1];
        boolean[]dp = new boolean[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = true;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<i;j++){
                if(!dp[j]) continue;
                int p = (i-j) * (1 + Math.abs(arr[j]-arr[i]));
                if(p<=K){
                    dp[i] = true;
                }
            }
        }
        System.out.println(dp[N] ? "YES" : "NO");
    }
}
