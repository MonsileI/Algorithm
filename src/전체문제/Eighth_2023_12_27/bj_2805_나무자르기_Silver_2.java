package 전체문제.Eighth_2023_12_27;
import java.util.*;
import java.io.*;
public class bj_2805_나무자르기_Silver_2 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =new int[N];
        st = new StringTokenizer(br.readLine()," ");
        long L = 0;
        long R = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R,arr[i]);
        }
        while(L<R){
            long mid = (L+R)/2;
            if(M<=check(mid)) L = mid+1;
            else R = mid;
        }
        System.out.println(L-1);
    }
    static long check(long mid){
        long tmp = 0;
        for(int i=0;i<N;i++){
            if(mid<arr[i]) tmp += arr[i]-mid;
        }
        return tmp;
    }
}
