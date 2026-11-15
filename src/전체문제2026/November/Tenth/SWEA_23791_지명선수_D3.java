package 전체문제2026.November.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_23791_지명선수_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            int N  =Integer.parseInt(br.readLine());
            int[]a = new int[N];
            int[]b = new int[N];
            st =new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken())-1;
            st =new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) b[i] = Integer.parseInt(st.nextToken())-1;
            int[]answer = new int[N];
            int aIdx = -1; int bIdx=-1;
            int cnt = 0;
            while(cnt<N){
                while(aIdx<N){
                    aIdx++;
                    if(answer[a[aIdx]]==0){
                        answer[a[aIdx]] = 1;
                        cnt++;
                        break;
                    }
                }
                if(N-1<cnt) break;
                while(bIdx<N){
                    bIdx++;
                    if(answer[b[bIdx]]==0){
                        answer[b[bIdx]] = 2;
                        cnt++;
                        break;
                    }
                }
            }
            for(int i=0;i<N;i++){
                if(answer[i]==1) sb.append("A");
                else sb.append("B");
            }
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
