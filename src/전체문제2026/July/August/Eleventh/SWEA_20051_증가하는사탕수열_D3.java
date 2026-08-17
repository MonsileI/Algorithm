package 전체문제2026.July.August.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_20051_증가하는사탕수열_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int answer = 0;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(c<=b) {
                answer += ((b-c)+1);
                b= c-1;
            }
            if(b<=a){
                answer += ((a-b)+1);
                a = b-1;
            }
            if(a<1||b<1||c<1) answer = -1;
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
