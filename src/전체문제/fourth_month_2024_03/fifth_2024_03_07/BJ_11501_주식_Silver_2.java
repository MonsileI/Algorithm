package 전체문제.fourth_month_2024_03.fifth_2024_03_07;
import java.util.*;
import java.io.*;
public class BJ_11501_주식_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st =new StringTokenizer(br.readLine()," ");
            long[]arr = new long[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            long max = arr[N-1]; long ans = 0;
            for(int i=N-1;-1<i;i--){
                if(max<arr[i]){
                    max = arr[i];
                }else{
                    ans += max - arr[i];
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
