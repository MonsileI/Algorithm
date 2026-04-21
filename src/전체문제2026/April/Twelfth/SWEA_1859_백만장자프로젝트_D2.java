package 전체문제2026.April.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_1859_백만장자프로젝트_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long answer = 0;
            for(int i=N-1;-1<i;i--){
                if(max<arr[i]){
                    max = arr[i];
                }else{
                    answer += (max-arr[i]);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
