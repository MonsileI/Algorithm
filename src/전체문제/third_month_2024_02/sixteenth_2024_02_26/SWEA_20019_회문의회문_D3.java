package 전체문제.third_month_2024_02.sixteenth_2024_02_26;
import java.util.*;
import java.io.*;
public class SWEA_20019_회문의회문_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        TC++;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<TC;t++){
            String str = br.readLine();
            int N = str.length()-1;
            int L = 0; int R = N;
            boolean flag = true;
            while(L<R){
                char f = str.charAt(L);
                char s = str.charAt(R);
                if(f!=s){
                    flag = false;
                    break;
                }
                L++;
                R--;
            }
            if(flag){
                L = 0; R = (N/2)-1;
                while(L<R){
                    char f= str.charAt(L);
                    char s= str.charAt(R);
                    if(f!=s){
                        flag= false;
                        break;
                    }
                    L++;
                    R--;
                }
            }
            sb.append("#"+t+" ");
            sb.append(flag ? "YES" : "NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
