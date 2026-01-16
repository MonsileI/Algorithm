package 전체문제2026.January.Ninth;

import java.util.*;
import java.io.*;
public class BJ_13305_주유소_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]len = new int[N-1];
        for(int i=0;i<N-1;i++) len[i] = Integer.parseInt(st.nextToken());
        int[]cost = new int[N];
        st=  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) cost[i] = Integer.parseInt(st.nextToken());
        long answer = 0;
        long min = cost[0];
        for(int i=0;i<N-1;i++){
            if(cost[i]<min) min = cost[i];
            answer += (len[i]*min);
        }
        System.out.println(answer);
    }
}
