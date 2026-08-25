package 전체문제2026.July.August.Seventh;

import java.util.*;
import java.io.*;
public class GR_최장공통문자열찾기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int aLen = a.length();
        int bLen = b.length();
        int cLen = c.length();
        int[][][]abcLcs = new int[aLen+1][bLen+1][cLen+1];
        for(int i=1;i<=aLen;i++){
            char aCh = a.charAt(i-1);
            for(int j=1;j<=bLen;j++){
                char bCh = b.charAt(j-1);
                for(int l=1;l<=cLen;l++) {
                    char cCh = c.charAt(l-1);
                    if(aCh==bCh && bCh==cCh){
                        abcLcs[i][j][l] = abcLcs[i-1][j-1][l-1] + 1;
                    }else{
                        abcLcs[i][j][l] = Math.max(abcLcs[i-1][j][l],Math.max(abcLcs[i][j-1][l],abcLcs[i][j][l-1]));
                    }
                }
            }
        }
        System.out.println(abcLcs[aLen][bLen][cLen]);
    }
}
