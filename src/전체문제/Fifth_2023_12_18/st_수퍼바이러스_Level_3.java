package 전체문제.Fifth_2023_12_18;
import java.util.*;
import java.io.*;
public class st_수퍼바이러스_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        //0.1초마다 증가
        long K = Integer.parseInt(st.nextToken()); //초기바이러스
        long P = Integer.parseInt(st.nextToken()); //증가율
        long N = Integer.parseInt(st.nextToken())*10; //N초 후 답 도출

        long ans = recursion(P,N);
        System.out.println(K*ans % 1000000007);
    }
    static long recursion(long p,long n){
        if(n==1) return p;
        long cur = recursion(p,n/2);
        if(n%2==1){
            return(cur * cur %1000000007) * p % 1000000007;
        }else{
            return cur * cur % 1000000007;
        }
    }
}
