package 전체문제2025.September.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_1049_기타줄_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //끊어진 줄의 개수
        int M = Integer.parseInt(st.nextToken()); //브랜드 개수
        int packStr = Integer.MAX_VALUE;
        int singStr = Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            packStr = Math.min(packStr,Integer.parseInt(st.nextToken()));
            singStr = Math.min(singStr,Integer.parseInt(st.nextToken()));
        }
        int sixMinPrice = Math.min((singStr*6),packStr);
        int answer = (sixMinPrice) * (N/6);
        N %= 6;
        answer += Math.min(sixMinPrice,(singStr*N));
        System.out.println(answer);
    }
}
