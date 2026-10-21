package 전체문제2026.October.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_5356_의석이의세로로말해요_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC=  Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            char[][]word = new char[5][];
            for(int i=0;i<5;i++){
                String str = br.readLine();
                word[i] = new char[str.length()];
                for(int j=0;j<str.length();j++){
                    word[i][j] = str.charAt(j);
                }
            }
            sb.append("#"+t+" ");
            int idx = 0;
            while(true){
                boolean flag = false;
                for(int i=0;i<5;i++){
                    if(word[i].length<=idx) continue;
                    flag = true;
                    sb.append(word[i][idx]);
                }
                if(!flag) break;
                idx++;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
