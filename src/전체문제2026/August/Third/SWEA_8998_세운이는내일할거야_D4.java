package 전체문제2026.August.Third;

import java.util.*;
import java.io.*;
public class SWEA_8998_세운이는내일할거야_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr,(o1,o2) -> -(o1[1] - o2[1]));
            int time = arr[0][1] - arr[0][0];
            for(int i=1;i<N;i++){
                if(arr[i][1] < time){
                    time = arr[i][1];
                }
                time -= arr[i][0];
            }
            sb.append("#"+t+" "+time+"\n");
        }
        System.out.println(sb.toString());
    }
}
