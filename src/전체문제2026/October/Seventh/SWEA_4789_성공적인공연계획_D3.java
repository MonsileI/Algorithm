package 전체문제2026.October.Seventh;

import java.util.*;
import java.io.*;
public class SWEA_4789_성공적인공연계획_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            char[]arr = br.readLine().toCharArray();
            //처음엔 0명
            int people = 0;
            int answer = 0;
            int N = arr.length;
            for(int i=0;i<N;i++){
                int p = arr[i] - '0';
                if(p==0) continue;
                if(people<i){
                    answer += (i-people);
                    people = i;
                }
                people += p;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
