package 전체문제2026.July.August.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_10204_초밥식사_D5 {
    static int N;
    static int [][]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = null;
        StringBuilder  sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            long answer = 0;
            Arrays.sort(arr, (o1, o2) ->
                    Integer.compare(o2[0] + o2[1], o1[0] + o1[1]));
            for(int i = 0; i < N; i++) {
                if(i % 2 == 0) {
                    answer += arr[i][0]; // 정연
                } else {
                    answer -= arr[i][1]; // 현용
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }

}
