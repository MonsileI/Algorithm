package 전체문제2025.December.Third;
import java.util.*;

public class PR_멀리뛰기_Level_2 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
    static long solution(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        int mod = 1234567;
        long[]arr = new long[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<n+1;i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % mod;
        }
        return arr[n];
    }
}

