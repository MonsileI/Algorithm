package 전체문제2025.September.Eighth;

import java.io.*;
public class BJ_20310_타노스_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int zero = 0;
        int one = 0;
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int N = str.length();
        int[] check = new int[N];
        for(int i=0;i<N;i++){
            if(str.charAt(i)=='1') one++;
            else zero++;
        }
        one /= 2; zero /= 2;
        for(int i = N-1; -1<i;i--){
            if(str.charAt(i)=='0'){
                check[i] = -1;
                zero--;
            }
            if(zero==0) break;
        }
        for(int i=0;i<N;i++){
            if(str.charAt(i)=='1'){
                check[i] = 1;
                one--;
            }
            if(one==0) break;
        }
        for(int i=0;i<N;i++){
            if(check[i]==0) sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
