package 문자열.KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class bj_11585_속타는저녁메뉴_Platinum_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = N*2;
        char[]str = new char[M];
        char[]pattern = new char[N];
        String[]tmp1 = br.readLine().split(" ");
        String[]tmp2 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            str[i] = tmp1[i].charAt(0);
            pattern[i] = tmp2[i].charAt(0);
        }
        for(int i=N;i<M;i++) str[i] = tmp1[i-N].charAt(0);
        int[]table = new int[N];
        int j =0 ;
        for(int i=1;i<N;i++){
            while(0 < j && pattern[i]!=pattern[j]) j = table[j-1];
            if(pattern[i]==pattern[j]) table[i] = ++j;
        }
        j = 0;
        int cnt = 0;
        for(int i=0;i<M-1;i++){
            while(0 < j && pattern[j]!=str[i]) j = table[j-1];
            if(pattern[j]==str[i]){
                if(j==N-1) {
                    cnt++;
                    j = table[j];
                }else j++;
            }
        }

            int a = gcd(N, cnt);
            System.out.println((cnt / a) + "/" + (N / a));

    }
    static int gcd(int a, int b){
        while(0<b){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
