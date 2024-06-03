package 전체문제.seventh_month_2024_06.first_2024_06_03;

import java.util.*;
import java.io.*;
public class BJ_13458_시험감독_Bronze_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        long ans = N;
        st = new StringTokenizer(br.readLine()," ");
        int boss = Integer.parseInt(st.nextToken());
        int assis = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            int tmp = arr[i]-boss;
            if(tmp<1) continue;
            ans += tmp/assis;
            if(tmp%assis!=0) ans++;
        }
        System.out.println(ans);


    }
}
