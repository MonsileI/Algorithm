package 전체문제.first_month_2023_12.second_2023_12_12;
import java.util.*;
import java.io.*;
public class BJ_1654_랜선자르기_Silver_2 {
    static int N,K;
    static long[]arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        long L = 0; long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R,arr[i]);
        }
        R++;
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid)<K) R = mid;
            else L = mid+1;
        }
        System.out.println(L-1);
    }
    static int check(long mid){
        int tmp = 0;
        for(int i=0;i<N;i++) tmp += (arr[i]/mid);
        return tmp;
    }
}
