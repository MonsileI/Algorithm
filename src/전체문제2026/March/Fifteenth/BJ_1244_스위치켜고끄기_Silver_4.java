package 전체문제2026.March.Fifteenth;

import java.util.*;
import java.io.*;
public class BJ_1244_스위치켜고끄기_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());
        for(int t=0;t<Q;t++){
            st = new StringTokenizer(br.readLine()," ");
            int gen = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(arr[num]==0) arr[num] = 1;
            else arr[num] = 0;
            if(gen==1){
                int tmp = num;
                tmp += num;
                while(true){
                    if(N<tmp) break;
                    if(arr[tmp]==0) arr[tmp] = 1;
                    else arr[tmp] = 0;
                    tmp += num;
                }
            }else if(gen==2){
                int L = num-1; int R = num+1;
                while(true){
                    if(L<1 || N < R) break;
                    if(arr[L]!=arr[R]) break;
                    if(arr[L]==0){
                        arr[L] = arr[R] = 1;
                    }else{
                        arr[L] = arr[R] = 0;
                    }
                    L--; R++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) {
            sb.append(arr[i]+" ");
            if(i%20==0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
