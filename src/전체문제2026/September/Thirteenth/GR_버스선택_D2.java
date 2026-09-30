package 전체문제2026.September.Thirteenth;

import java.util.*;
import java.io.*;
public class GR_버스선택_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int tmp = 0;
            if(K<=s) tmp = s;
            else {
                tmp = s + ((K-s)/d)*d;
                if((K-s)%d!=0) tmp += d;
            }
            if(tmp<min){
                min = tmp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}