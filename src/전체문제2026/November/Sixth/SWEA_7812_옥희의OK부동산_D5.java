package 전체문제2026.November.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_7812_옥희의OK부동산_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            int L = 0; int R = 1;
            long cur = arr[0];
            int answer = 0;
            while(L<N){
                if(cur<=M){
                    if(cur==M) answer++;
                    if(R==N) break;
                    cur += arr[R++];
                }else{
                    cur -= arr[L++];
                }
            }
            sb.append("#"+t+" "+answer+"\n");
            
        }
        System.out.println(sb.toString());
    }
}