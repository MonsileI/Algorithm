package 전체문제.seven_month_2024_06.fourth_2024_06_08;

import java.util.*;
import java.io.*;
public class BJ_3584_가장가까운공통조상_Gold_4 {
    static int N;
    static int[]parents;
    static boolean[]visited;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            N = Integer.parseInt(br.readLine());
            parents = new int[N+1];
            visited = new boolean[N+1];
            for(int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parents[b] = a;
            }
            st = new StringTokenizer(br.readLine()," ");
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            ans = 0;
            calc(fir,sec);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
    static void calc(int fir,int sec){
        while(fir!=0){
            visited[fir] = true;
            fir = parents[fir];
        }
        while(true){
            if(visited[sec]){
                ans = sec;
                return;
            }
            sec = parents[sec];
        }
    }

}
