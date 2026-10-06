package 전체문제2026.October.Second;

import java.util.*;
import java.io.*;
public class SWEA_9229_한빈이와SpotMart_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int answer = -1;
            for(int i=0;i<N-1;i++){
                int L = i+1; int R = N-1;
                while(L<R){
                    int mid = (L+R)/2;
                    if(M<arr[i]+arr[mid]) R = mid;
                    else L = mid+1;
                }
                // L이 초과 지점인 경우
                if(M < arr[i]+arr[L]){
                    L--;
                }

                // L이 가능한 마지막 위치
                if(L > i){
                    answer = Math.max(answer, arr[i]+arr[L]);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
