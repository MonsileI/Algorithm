package 전체문제2026.September.Fourth;

import java.util.*;
import java.io.*;
public class GR_어부의고기잡기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N+1];
        st =new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }
        int L = 0; int R = 1;
        int answer = 0;
        while(L<=N){
            int diff = arr[R] - arr[L];
            if(arr[R]-arr[L]<=M){
                if(diff==M) {
                    answer++;
                }
                if(R==N) break;
                R++;
            }else{
                L++;
            }
        }
        System.out.println(answer);
    }
}
