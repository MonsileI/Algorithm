package 전체문제2026.July.August.Eighth;

import java.util.*;
import java.io.*;
public class SWEA_1225_암호생성기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = 10;
        int N = 8;
        int cycle = 15;
        int []move = {1,2,3,4,5};
        for(int t=1;t<=TC;t++){
            br.readLine();
            int calc = 1; //int 범위
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                min= Math.min(min,(arr[i]/cycle));
            }
            min--;
            for(int i=0;i<N;i++) arr[i] -= (cycle*min);
            int mIdx = 0;
            int idx = 0;
            while(true){
                if(idx==8) idx = 0;
                if(mIdx==5) mIdx = 0;
                arr[idx] -= move[mIdx];
                if(arr[idx]<=0){
                    arr[idx] = 0;
                    idx++;
                    if(idx==8) idx = 0;
                    break;
                }
                idx++;
                mIdx++;
            }
            int cnt = 0;
            sb.append("#"+t+" ");
            while(true){
                sb.append(arr[idx]);
                idx++;
                if(idx==8) idx = 0;
                cnt++;
                if(cnt==8) break;
                sb.append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }
}
