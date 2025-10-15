package 전체문제2025.September.Sixth;

import java.util.Arrays;

public class PR_멀리뛰기_Level_2 {
    public static void main(String[] args) {
        int n = 4; //result 5
        //int n = 3; //result 3;
        System.out.println(solution(n));
    }
    static long solution(int n){
        int[] fibo = new int[n + 2];
        fibo[1] = 1;
        fibo[2] = 2;

        for (int i = 3; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return fibo[n];
    }
}
