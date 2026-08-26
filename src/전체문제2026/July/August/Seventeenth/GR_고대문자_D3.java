package 전체문제2026.July.August.Seventeenth;

import java.util.*;
import java.io.*;
public class GR_고대문자_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int aLen = a.length();
        int bLen = b.length();
        int[][]lcs = new int[aLen+1][bLen+1];
        for(int i=1;i<=aLen;i++){
            char aCh = a.charAt(i-1);
            for(int j=1;j<=bLen;j++){
                char bCh = b.charAt(j-1);
                if(aCh==bCh) lcs[i][j] = lcs[i-1][j-1] + 1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        System.out.println(lcs[aLen][bLen]);
    }
}
