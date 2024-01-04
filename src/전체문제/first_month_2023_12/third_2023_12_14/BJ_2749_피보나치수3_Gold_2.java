package 전체문제.first_month_2023_12.third_2023_12_14;
import java.io.*;
public class BJ_2749_피보나치수3_Gold_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int pisano = 15000000;
        long n = Long.parseLong(br.readLine()) % pisano;
        long[] arr = new long[pisano+1];
        arr[0] = 0; arr[1] = 1;
        int mod = 1000000;
        for(int i=2;i<pisano+1;i++) arr[i] = (arr[i-1] + arr[i-2] ) % mod;
        System.out.println(arr[(int)n]);
    }
}
