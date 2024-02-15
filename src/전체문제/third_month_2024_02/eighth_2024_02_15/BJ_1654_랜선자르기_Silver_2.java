package 전체문제.third_month_2024_02.eighth_2024_02_15;
import java.util.*;
import java.io.*;
public class BJ_1654_랜선자르기_Silver_2 {
    static int K,N;
    static int []arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr =new int[K];
        long L = 0; long R = 0;
        for(int i=0;i<K;i++){
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R,arr[i]);
        }
        R++;
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid)>=N) L = mid+1;
            else R = mid;
        }
        System.out.println(L-1);
    }
    static long check(long mid){
        long tmp = 0;
        for(int i=0;i<K;i++){
            tmp += arr[i]/mid;
        }
        return tmp;
    }
}
