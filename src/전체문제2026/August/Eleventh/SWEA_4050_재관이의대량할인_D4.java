package 전체문제2026.August.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_4050_재관이의대량할인_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            long answer = 0;
            if(N<2){
                for(int i=0;i<N;i++) answer += arr[i];
            }else{
                Arrays.sort(arr);
                int idx = N-1;
                while(true){
                    if(idx<2){
                        for(int i=idx;-1<i;i--){
                            answer += arr[i];
                        }
                        break;
                    }
                    answer += arr[idx];
                    answer += arr[idx-1];
                    idx -= 3;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
            }
        System.out.println(sb.toString());
    }

}
