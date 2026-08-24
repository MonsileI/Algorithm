package 전체문제2026.July.August.Sixteenth;

import java.util.*;
import java.io.*;
public class GR_가장작은회문구하기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = str.charAt(i) - '0';
        int  L = 0; int R = N-1;
        int cnt = 0;
        int answer = 0;
        boolean[]check = new boolean[N];
        while(L<=R){

            if(arr[L]!=arr[R]){
                arr[L] = arr[R] = Math.min(arr[L],arr[R]);
                cnt++;
                check[L] = true;
            }
            if(M<cnt) {
              answer = -1;
              break;
            }
            L++; R--;
        }
        L = 0; R = N-1;
        M -= cnt;
        while(0<M && (L<=R)){
            if (L == R) {
                arr[L] = 0;
                break;
            }
            if(check[L]){
                M--;
                arr[L] = arr[R] = 0;
            }else{
                if(1<M){
                    M -= 2;
                    arr[L] = arr[R] = 0;
                }
            }
            L++; R--;
        }
        if(answer==-1){
            System.out.println(answer);
        }else{
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<N;i++) sb.append(arr[i]);
            System.out.println(sb.toString());
        }
    }
}
