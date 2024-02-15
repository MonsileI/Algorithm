package 전체문제.third_month_2024_02.eighth_2024_02_15;
import java.util.*;
import java.io.*;
public class BJ_2343_기타레슨_Silver_1 {
    static int N,M;
    static int []arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        long L = 0 ; long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            L = Math.max(L,arr[i]);
            R += arr[i];
        }
        while(L<R){
            long mid = (L+R)/2;
            if(check(mid)>=M) L = mid+1;
            else R = mid;
        }
        System.out.println(L);
    }
    static int check(long mid){
        int cnt = 0;
        long now = 0;
        for(int i=0;i<N;i++){
            if(now+arr[i]>mid){
                now = arr[i];
                cnt++;
            }else now += arr[i];
        }
        return cnt;
    }
}
