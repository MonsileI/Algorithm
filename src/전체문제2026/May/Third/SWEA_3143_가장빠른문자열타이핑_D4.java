package 전체문제2026.May.Third;

import java.util.*;
import java.io.*;
public class SWEA_3143_가장빠른문자열타이핑_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            String tmp = st.nextToken();
            int sLen = str.length();
            int tLen = tmp.length();
            char tFir = tmp.charAt(0);
             int answer = 0;
            for(int i=0;i<sLen;i++){
                 char ch = str.charAt(i);
                 if(ch==tFir){
                    boolean flag = true;
                    int idx = 0;
                    for(int j=i;j<i+tLen;j++){
                        if(sLen<=j) {
                            flag= false;
                            break;
                        }
                        char sCh = str.charAt(j);
                        if(sCh!=tmp.charAt(idx)){
                            flag =  false;
                            break;
                        }
                        idx++;
                    }
                    if(flag){
                        i += (tLen-1);
                    }
                 }
                answer++;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
