package 전체문제.first_month_2023_12.second_2023_12_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(0<N){
            if(N%5==0) {
                ans += N/5;
                break;
            }
            N -= 3;
            ans++;
        }
        System.out.println(N<0 ? -1 : ans);
    }
}
