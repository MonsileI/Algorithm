package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_4796_캠핑장_Bronze_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = 1;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(L==0) break;
            int total = V/P;
            int ans = (total*L) + (V%P);
            if(L<(V%P)){
                ans -= (V%P);
                ans += L;
            }
            sb.append("Case "+TC+": "+ans+"\n");
            TC++;
        }
        System.out.println(sb.toString());
    }
}
