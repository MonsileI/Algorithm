package 전체문제.fifth_month_2023_04.ninth_2024_04_15;

import java.util.*;
import java.io.*;
public class ST_성적평균_Level_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        int sum  =0;
        for(int i=1;i<N+1;i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken());
            double avg = (double)(arr[e]-arr[s]) / (double)(e-s);
            String str = String.valueOf(Math.round(avg*100)/100.0);
            if(str.charAt(str.length()-2)=='.') str += '0';
            sb.append(str+"\n");
        }
        System.out.println(sb.toString());
    }
}
