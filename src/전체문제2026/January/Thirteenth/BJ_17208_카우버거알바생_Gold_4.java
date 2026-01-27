package 전체문제2026.January.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_17208_카우버거알바생_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int [] cheeze = new int[N+1];
        int [] potato = new int[N+1];
        int[][]dp = new int[C+1][P+1];
        for(int i=1;i<N+1;i++){
            st= new StringTokenizer(br.readLine()," ");
            cheeze[i] = Integer.parseInt(st.nextToken());
            potato[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            int ch = cheeze[i];
            int po = potato[i];
            for(int j=C;ch<=j;j--){
                for(int l=P;po<=l;l--){
                    dp[j][l] = Math.max(dp[j][l],dp[j-ch][l-po]+1);
                }
            }
        }
        System.out.println(dp[C][P]);
    }
}
