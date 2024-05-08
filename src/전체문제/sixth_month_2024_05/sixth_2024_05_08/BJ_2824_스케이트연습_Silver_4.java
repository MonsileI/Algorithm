package 전체문제.sixth_month_2024_05.sixth_2024_05_08;

import java.util.*;
import java.io.*;
public class BJ_2824_스케이트연습_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int after = 0;
        long ans = 0;
        for(int i=N-1;-1<i;i--){
            if(after>=arr[i]) after = arr[i];
            else after++;
            ans += after;
        }
        System.out.println(ans);
    }
}
