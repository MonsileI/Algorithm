package 전체문제.ninth_month_2024_10;

import java.util.*;
import java.io.*;
public class BJ_9251_LCS_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int aSize = a.length();
        int bSize = b.length();
        int[][]lcs = new int[aSize+1][bSize+1];
        for(int i=1;i<aSize+1;i++) {
            char ch = a.charAt(i-1);
            for (int j = 1; j < bSize+1; j++) {
                if (b.charAt(j-1) == ch) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }

        System.out.println(lcs[aSize][bSize]);
    }
}
