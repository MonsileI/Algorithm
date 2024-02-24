package 전체문제.third_month_2024_02.fifteenth_2024_02_24;
import java.util.*;
import java.io.*;
public class BJ_2805_나무자르기_Silver_2 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long L = 0; long R=0;
        arr= new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }
        R++;
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid)<M) R = mid;
            else L = mid+1;
        }
        System.out.println(L-1);
    }
    static long check(long mid){
        long tmp = 0;
        for(int i=0;i<N;i++) if(arr[i]>mid) tmp += (arr[i]-mid);
        return tmp;
    }
}
