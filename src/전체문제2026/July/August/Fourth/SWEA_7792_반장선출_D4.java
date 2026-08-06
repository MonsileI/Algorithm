package 전체문제2026.July.August.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_7792_반장선출_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int max = 0;
            String answer = "";
            for(int i=0;i<N;i++){
                boolean[]alpha = new boolean[26];
                String str = br.readLine();
                int cnt = 0;
                for(int j=0;j<str.length();j++){
                    char ch = str.charAt(j);
                    if(ch==' ') continue;
                    if(!alpha[ch-'A']){
                        alpha[ch-'A'] = true;
                        cnt++;
                    }
                }
                if(max<cnt){
                    max = cnt;
                    answer = str;
                }else if(max==cnt){
                    answer = answer.compareTo(str) > 0 ? str : answer;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}