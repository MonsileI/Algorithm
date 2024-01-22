package 전체문제.second_month_2024_01.fourteenth_2024_01_22;
import java.util.*;
import java.io.*;
public class BJ_13019_A를B로_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //우선 개수가 같은지 확인
        String fir = br.readLine();
        String sec = br.readLine();
        int N = fir.length();
        int[]alpha = new int[26];
        for(int i=0;i<N;i++){
            int idx =fir.charAt(i)-'A';
            alpha[idx]++;
        }
        boolean flag = true;
        for(int i=0;i<N;i++){
            int idx = sec.charAt(i)-'A';
            if(alpha[idx]==0) {
                flag =false;
                break;
            }
            alpha[idx]--;
        }
        if(!flag) System.out.println(-1);
        else{
            int cnt = 0;
            for(int i=N-1;-1<i;i--){
                if(fir.charAt(i)==sec.charAt(N-cnt-1)) cnt++;
            }
            System.out.println(N-cnt);
        }
    }
}
