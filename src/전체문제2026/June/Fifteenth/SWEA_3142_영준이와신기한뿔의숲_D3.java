package 전체문제2026.June.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_3142_영준이와신기한뿔의숲_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken()); //뿔의 개수
            int m = Integer.parseInt(st.nextToken()); //동물 수
            int uni = m;
            int twin = 0;
            while(true){
                int sum = uni+ (twin*2);
                if(sum==n) break;
                if(sum<n) {
                    uni--;
                    twin++;
                }else{
                    uni++;
                    twin--;
                }
            }
            sb.append("#"+t+" "+uni+" "+twin+"\n");
        }
        System.out.println(sb.toString());
    }
}
