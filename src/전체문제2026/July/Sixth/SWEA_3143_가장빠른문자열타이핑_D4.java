package 전체문제2026.July.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_3143_가장빠른문자열타이핑_D4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            String a = st.nextToken();
            String b = st.nextToken();
            a = a.replaceAll(b," ");
            int N = a.length();
            sb.append("#"+t+" "+N+"\n");
        }
        System.out.println(sb.toString());
    }
}
