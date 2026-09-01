package 전체문제2026.August.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_1860_진기의최고급붕어빵_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String POSITIVE = "Possible";
        String NEGATIVE = "Impossible";
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken()); //손님
            int M = Integer.parseInt(st.nextToken()); //분
            int K = Integer.parseInt(st.nextToken()); //개수
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            sb.append("#"+t+" ");
            int mine = 0;
            int second = 0;
            boolean flag = true;
            for(int i=0;i<N;i++){
                int diff = arr[i] - second;
                if(M<=diff){
                    mine += (diff/M) * K;
                }
                if(mine<1){
                    flag = false;
                    break;
                }
                mine--;
                second = (arr[i]/M) * M;
            }
            if(flag) sb.append(POSITIVE);
            else sb.append(NEGATIVE);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
