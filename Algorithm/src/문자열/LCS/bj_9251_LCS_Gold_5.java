package 문자열.LCS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_9251_LCS_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int fSize= first.length();
        int sSize = second.length();
        int[][]lcs = new int[fSize+1][sSize+1];
        for(int i=1;i<fSize+1;i++){
            char f = first.charAt(i-1);
            for(int j=1;j<sSize+1;j++){
                char s = second.charAt(j-1);
                if(f==s) lcs[i][j] = lcs[i-1][j-1]+1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        System.out.println(lcs[fSize][sSize]);
    }
}
