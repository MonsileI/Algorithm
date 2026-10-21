package 전체문제2026.October.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_3499_퍼펙트셔플_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            st= new StringTokenizer(br.readLine()," ");
            String[]arr =new String[N];
            for(int i=0;i<N;i++) arr[i] = st.nextToken();
            int firIdx = 0; int secIdx = N/2;
            if(N%2==1) secIdx++;
            int cnt = 0;
            sb.append("#"+t+" ");
            while(cnt<N){
                sb.append(arr[firIdx++]+" ");
                cnt++;
                if(N-1<secIdx) continue;
                sb.append(arr[secIdx++]+" ");
                cnt++;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
