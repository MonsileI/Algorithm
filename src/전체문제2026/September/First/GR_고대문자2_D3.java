package 전체문제2026.September.First;

import java.util.*;
import java.io.*;
public class GR_고대문자2_D3 {
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
                if(aCh==bCh) lcs[i][j] = lcs[i-1][j-1]+1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        int cnt = lcs[aLen][bLen];
        int i = aLen;
        int j = bLen;
        StringBuilder sb= new StringBuilder();
        while(0<i && 0<j){
            // 현재 문자가 같으면 LCS에 포함
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            }
            // 위쪽과 왼쪽 중 LCS 길이가 유지되는 방향으로 이동
            else if (lcs[i - 1][j] >= lcs[i][j - 1]) {
                i--;
            }
            else {
                j--;
            }
        }
        System.out.println(cnt);
        System.out.println(sb.reverse().toString());
    }
}
