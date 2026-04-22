package 전체문제2026.April.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_2805_농작물수확하기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int cnt = N/2;
            int answer = 0;
            for(int i=0;i<N;i++){
                char[]arr = br.readLine().toCharArray();
                for(int j=cnt;j<N-cnt;j++){
                    answer += arr[j] -'0';
                }
                if(i<N/2) {
                    cnt--;
                }else{
                    cnt++;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
