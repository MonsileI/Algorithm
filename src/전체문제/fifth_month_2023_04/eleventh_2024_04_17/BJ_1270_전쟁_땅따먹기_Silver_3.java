package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1270_전쟁_땅따먹기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            long[]arr = new long[N];
            for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());
            Arrays.sort(arr);
            int cnt = 1;
            long num = arr[0];
            long ans = -1;
            for(int i=1;i<N;i++){
                if(num!=arr[i]) {
                    cnt = 1;
                    num = arr[i];
                    continue;
                }
                cnt++;
                if(cnt>N/2){
                    ans = num;
                    break;
                }
            }
            if(ans==-1) sb.append("SYJKGW\n");
            else sb.append(num+"\n");
        }
        System.out.println(sb.toString());

    }
}
