package 전체문제.second_month_2024_01.fifteen_2024_01_23;
import java.util.*;
import java.io.*;
public class BJ_16472_고냥이_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //총 번역 개수
        int[]alpha = new int[27];
        String str = br.readLine();
        int L = 0 ; int R = 0;
        alpha[str.charAt(0)-'a']++;
        int len = 1;
        int cnt = 1;
        int total = str.length();
        OuterLoop:
        while(R<total){
            R++;
            if(R==total) break;
            int RIdx = str.charAt(R) - 'a';
            alpha[RIdx]++;
            if(alpha[RIdx]==1){
                cnt++;
                if(cnt>N){
                    while(true){
                        int LIdx = str.charAt(L) - 'a';
                        alpha[LIdx]--;
                        L++;
                        if(alpha[LIdx]==0) {
                            cnt--;
                            break;
                        }
                        if(L==total) break OuterLoop;
                    }
                }
            }
            len = Math.max(len,(R-L)+1);
        }
        System.out.println(len);
    }
}
