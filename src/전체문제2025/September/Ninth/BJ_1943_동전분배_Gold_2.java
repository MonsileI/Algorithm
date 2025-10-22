package 전체문제2025.September.Ninth;

import java.util.*;
import java.io.*;
public class BJ_1943_동전분배_Gold_2 {

    static class Coin{
        int price;
        int cnt;

        public Coin(int price, int cnt) {
            this.price = price;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = 3;
        while(0<TC){
            int N = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[N+1];
            int sum  =0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine()," ");
                int price = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(price,cnt);
                sum += (price * cnt);
            }
            if(sum % 2 !=0){
                sb.append(0);
            }else{
                sum /= 2;
                boolean[][]dp = new boolean[N+1][sum+1];
                dp[0][0] = true;
                for(int i=1;i<N+1;i++){
                    Coin cur = coins[i-1];
                    for(int j=0;j<sum+1;j++){
                        if(dp[i-1][j]){
                            for(int k=0;k<cur.cnt+1;k++){
                                int tempAmount = j + cur.price * k;
                                if(tempAmount <= sum){
                                    dp[i][tempAmount] = true;
                                }
                            }
                        }
                    }
                }
                if(dp[N][sum]==true){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }

            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
