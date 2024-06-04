package 전체문제.seven_month_2024_06.second_2024_06_04;

import java.util.*;
import java.io.*;
public class BJ_9251_LCS_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        int f = fir.length();
        int s = sec.length();
        int[][]lcs = new int[f+1][s+1];
        for(int i=1;i<f+1;i++){
            char fch = fir.charAt(i-1);
            for(int j=1;j<s+1;j++){
                char sch = sec.charAt(j-1);
                if(fch==sch) lcs[i][j] = lcs[i-1][j-1] +1;
                else lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
            }
        }
        System.out.println(lcs[f][s]);
    }
}
