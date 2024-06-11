package 전체문제.seven_month_2024_06.sixth_2024_06_11;

import java.util.*;
import java.io.*;
public class BJ_12841_정보대등산_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[]cross = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) cross[i] = Long.parseLong(st.nextToken());
        long[]left = new long[N-1];
        long[]right = new long[N-1];
        st = new StringTokenizer(br.readLine()," ");
        long sum  =0;
        for(int i=0;i<N-1;i++){
            sum += Long.parseLong(st.nextToken());
            left[i] = sum;
        }
        st = new StringTokenizer(br.readLine()," ");
        sum  =0;
        for(int i=0;i<N-1;i++) right[i]= Long.parseLong(st.nextToken());
        for(int i=N-2;-1<i;i--){
            sum += right[i];
            right[i] = sum;
        }
        long min = cross[0] + right[0];
        int ans = 1;
        for(int i=0;i<N-2;i++){
            sum = left[i] + cross[i+1] + right[i+1];
            if(sum<min){
                min = sum;
                ans = (i+2);
            }
        }
        sum = left[N-2] + cross[N-1];
        if(sum<min){
            min = sum;
            ans = N-1;
        }
        System.out.println(ans+" "+min);
    }
}
