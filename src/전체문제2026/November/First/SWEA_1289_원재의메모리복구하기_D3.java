package 전체문제2026.November.First;

import java.util.*;
import java.io.*;
public class SWEA_1289_원재의메모리복구하기_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            String num = br.readLine();
            int answer = 0;
            int N = num.length();
            boolean flag = false; //아무것도 안 킨 상태
            for(int i=0;i<N;i++){
                char ch = num.charAt(i);
                if(ch=='1'){
                    if(!flag){
                        flag = true;
                        answer++;
                    }
                }else{
                    if(flag){
                        flag = false;
                        answer++;
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
