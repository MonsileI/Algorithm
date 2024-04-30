package 전체문제.fifth_month_2023_04.sixteenth_2024_04_24;
import java.util.*;
import java.io.*;
public class BJ_4929_수열걷기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            int[]arrF = new int[N];
            for(int i=0;i<N;i++)arrF[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int[]arrS = new int[M];
            for(int i=0;i<M;i++)arrS[i] = Integer.parseInt(st.nextToken());
            int idx = 0;
            int f = 0 ; int s = 0;
            int ans = 0;
            for(int i=0;i<N;i++){
                f += arrF[i];
                if(arrF[i]>=arrS[idx]){
                    while(idx<M-1){
                        if(arrF[i]<=arrS[idx]) break;
                        s += arrS[idx++];
                    }
                }
                if(arrF[i]==arrS[idx]){
                    ans += Math.max(f,s);
                    f=0;s=0;
                }
            }
            if(idx<M) {
                while (idx<M) {
                    s += arrS[idx++];
                }
            }
            System.out.println(f+" "+s);
            ans += Math.max(f,s);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
