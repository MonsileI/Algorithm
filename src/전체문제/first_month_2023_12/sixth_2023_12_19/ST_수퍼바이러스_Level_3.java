package 전체문제.first_month_2023_12.sixth_2023_12_19;
import java.util.*;
import java.io.*;
public class ST_수퍼바이러스_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken()) * 10;
        //1000000007

        long result = calc(P,N);
        System.out.println(result*K % 1000000007);
    }
    static long calc(long p,long n){
        if(n==1) return p;

        long cur = calc(p,n/2);

        if(n%2==1){
            return (cur * cur % 1000000007) * p % 1000000007;
        }else{
            return cur * cur % 1000000007;
        }
    }
}
