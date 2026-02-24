package 전체문제2026.February.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_1614_영식이의손가락_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int F = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        //40까지 [5, 10, 10, 10 ,5]
        int cnt = 0;
        if(F==1 || F==5){
            cnt = 5;
        }else{
            cnt = 10;
        }
        long ans = (N/cnt);
        ans *= 40;
        N %= cnt;
        int num = 1;
        boolean flag = true;
        while(true){
            if(num==F) {
                N--;
                if(N<0) break;
            }
            ans++;
            if(num == 1) flag = true;
            if(num == 5) flag = false;

            if(flag) num++;
            else num--;
        }
        System.out.println(ans);
    }
}
