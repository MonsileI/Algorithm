package 전체문제.third_month_2024_02.eleventh_2024_02_20;
import java.util.*;
import java.io.*;
public class BJ_2512_예산_Silver_2 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        long L = 0; long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }
        R++;
        M = Integer.parseInt(br.readLine());
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid)<=M) L = mid+1;
            else R = mid;
        }
        System.out.println(L-1);
    }
    static long check(long mid){
        long sum  = 0;
        for(int i=0;i<N;i++){
            if(arr[i]>mid) sum += mid;
            else sum += arr[i];
        }
        return sum;
    }
}
