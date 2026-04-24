package 전체문제2026.April.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_1213_String_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
        StringBuilder sb=  new StringBuilder();
        while(0<TC) {
            int t = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String str = br.readLine();
            int answer = 0;
            int wLen = word.length();
            int strLen = str.length();
            for(int i=0;i<=strLen-wLen;i++){
                int idx = 0;
                boolean flag = true;
                for(int j=i;j<i+wLen;j++){
                    if(word.charAt(idx++)!=str.charAt(j)){
                        flag=  false;
                        break;
                    }
                }
                if(flag) answer++;
            }
            sb.append("#"+t+" "+answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
