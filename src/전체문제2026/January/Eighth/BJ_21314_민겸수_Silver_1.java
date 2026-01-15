package 전체문제2026.January.Eighth;

import java.util.*;
import java.io.*;
public class BJ_21314_민겸수_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();

        //최댓값
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(str.charAt(i)=='K'){
                sb.append('5');
                while(0<cnt){
                    sb.append('0');
                    cnt--;

                }
            }else{
                cnt++;
            }
        }
        if(cnt!=0){
            sb.append('1');
            cnt--;
            while(0<cnt){
                sb.append('1');
                cnt--;
            }
        }
        String max = sb.toString();
        //최솟값
        sb = new StringBuilder();
        cnt = 0;
        for(int i=0;i<N;i++){
            if(str.charAt(i)=='K'){
                if(cnt!=0) {
                    sb.append('1');
                    cnt--;
                    while (0 < cnt) {
                        sb.append('0');
                        cnt--;
                    }
                }
                sb.append('5');
            }else{
                cnt++;
            }
        }
        if(cnt!=0){
            sb.append('1');
            cnt--;
            while(0<cnt){
                sb.append('0');
                cnt--;
            }
        }
        String min = sb.toString();
        System.out.println(max);
        System.out.println(min);

    }
}
