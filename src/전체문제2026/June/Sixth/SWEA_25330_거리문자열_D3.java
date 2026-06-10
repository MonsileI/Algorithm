package 전체문제2026.June.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_25330_거리문자열_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            String str = br.readLine();
            int[]num = new int[10];
            int N = str.length();
            boolean flag = true;
            for(int i=0;i<N;i++){
                int n = str.charAt(i)-'0';
                num[n]++;
                if(2<num[n]){
                    flag = false;
                    break;
                }
                if(num[n]==2){
                    int idx = i - n -1;
                    if(idx<0) {
                        flag = false;
                        break;
                    }
                    if((str.charAt(idx)-'0') != n){
                        flag= false;
                        break;
                    }
                }
            }
            for(int i=0;i<10;i++){
                if(num[i]==1){
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "yes" : "no");
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}

