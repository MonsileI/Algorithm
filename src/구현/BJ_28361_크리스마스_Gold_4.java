package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_28361_크리스마스_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        sb.append(N+"\n"+"1 ");
        int[]arr = {2,-1,2};
        int num = 2;
        int d = 0;
        if(N%3==0){
            sb.append("3 ");
            d=1;
            num = 3;
        }else sb.append("2 ");
        while(2<N){
            num += arr[d++];
            sb.append(num+" ");
            if(d==3) d=0;
            N--;
        }
        sb.append(1);
        System.out.println(sb.toString());

    }
}
