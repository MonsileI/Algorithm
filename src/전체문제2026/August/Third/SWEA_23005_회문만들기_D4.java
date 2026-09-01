package 전체문제2026.August.Third;

import java.util.*;
import java.io.*;
public class SWEA_23005_회문만들기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            String str = br.readLine();
            int N = str.length();
            int L = 0;
            int R = N-1;
            int answer = 0;
            while(L<=R){
                char lCh = str.charAt(L);
                char rCh = str.charAt(R);
                if(lCh==rCh){
                    L++;
                    R--;
                }else{
                    if(lCh!='x' && rCh!='x'){
                        answer = -1;
                        break;
                    }
                    if(lCh=='x') {
                        answer++;
                        L++;
                    }
                    if(rCh=='x') {
                        answer++;
                        R--;
                    }
                }
            }
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
