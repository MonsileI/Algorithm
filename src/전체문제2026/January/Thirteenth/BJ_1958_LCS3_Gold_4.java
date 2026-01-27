package 전체문제2026.January.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_1958_LCS3_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        String thir = br.readLine();
        int fLen = fir.length();
        int sLen = sec.length();
        int tLen = thir.length();
        int[][][]dp = new int[fLen+1][sLen+1][tLen+1];

        for(int i=1;i<fLen+1;i++){
            char f = fir.charAt(i-1);
            for(int j=1;j<sLen+1;j++){
                char s = sec.charAt(j-1);
                for(int l=1;l<tLen+1;l++){
                    char t = thir.charAt(l-1);
                    if(f==s && s==t){
                        dp[i][j][l] = dp[i-1][j-1][l-1] + 1;
                    }else{
                        dp[i][j][l] = Math.max(dp[i-1][j][l],Math.max(dp[i][j-1][l],dp[i][j][l-1]));
                    }
                }
            }
        }
        System.out.println(dp[fLen][sLen][tLen]);

    }
}
