package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_13305_주유소_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]road = new int[N-1];
        int[]oil = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N-1;i++)road[i]= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)oil[i]= Integer.parseInt(st.nextToken());
        long ans = 0;
        long min = oil[0];
        for(int i=0;i<N-1;i++){
            if(oil[i]<min) min = oil[i];
            ans += (road[i]*min);
        }
        System.out.println(ans);
    }
}
