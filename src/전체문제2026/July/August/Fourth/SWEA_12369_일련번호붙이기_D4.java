package 전체문제2026.July.August.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_12369_일련번호붙이기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            long num = Long.parseLong(st.nextToken());
            int N = str.length();
            StringBuilder smallSb = new StringBuilder();
            while(0 < num){
                num--;
                int idx = (int)(num % N);
                smallSb.append(str.charAt(idx));
                num /= N;
            }
            sb.append("#"+t+" ");
            sb.append(smallSb.reverse().toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
