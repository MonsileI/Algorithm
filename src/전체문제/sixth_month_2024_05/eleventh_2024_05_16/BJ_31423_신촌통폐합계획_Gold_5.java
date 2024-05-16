package 전체문제.sixth_month_2024_05.eleventh_2024_05_16;

import java.util.*;
import java.io.*;
public class BJ_31423_신촌통폐합계획_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N+1];
        for(int i=1;i<N+1;i++) str[i] = br.readLine();
        StringTokenizer st = null;
        int[]tails = new int[N+1];
        for(int i=1;i<N+1;i++) tails[i] = i;
        int[]now = new int[N+1];
        int cur = 0;
        for(int i=0;i<N-1;i++){
            st =  new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            now[tails[a]] = b;
            tails[a] = tails[b];
            cur = a;
        }
        StringBuilder sb= new StringBuilder();
        while(cur!=0){
            sb.append(str[cur]);
            cur = now[cur];
        }
        System.out.println(sb.toString());
    }
}
