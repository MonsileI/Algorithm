package 문자열.LCS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_17218_비밀번호만들기_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader  br=  new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        int fSize = f.length();
        int sSize = s.length();
        int[][] lcs = new int[fSize+1][sSize+1];
        for(int i=1;i<fSize+1;i++){
            char fch = f.charAt(i-1);
            for(int j=1;j<sSize+1;j++){
                char sch = s.charAt(j-1);
                if(fch==sch) lcs[i][j] = lcs[i-1][j-1]+1;
                else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(true){
            if(fSize==0||sSize==0) break;
            if(lcs[fSize-1][sSize]==lcs[fSize][sSize]) {
                fSize--;
                continue;
            }
            if(lcs[fSize][sSize-1]==lcs[fSize][sSize]){
                sSize--;
                continue;
            }
            sb.insert(0,f.charAt(fSize-1));
            fSize--; sSize--;
        }
        System.out.println(sb.toString());
    }
}
