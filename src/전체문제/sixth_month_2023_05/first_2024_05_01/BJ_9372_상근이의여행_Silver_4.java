package 전체문제.sixth_month_2023_05.first_2024_05_01;

import java.util.*;
import java.io.*;
public class BJ_9372_상근이의여행_Silver_4 {

    static int N;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(N-1+"\n");
            for(int i=0;i<M;i++) br.readLine();
        }
        System.out.println(sb.toString());

    }
}
