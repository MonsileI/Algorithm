package 전체문제2026.November.Eighteenth;

import java.util.*;
import java.io.*;
public class BJ_15686_치킨배달_Gold_5 {
    static int N;
    static int M; //치킨집 개수
    static List<int[]> chicken;
    static List<int[]> home;
    static int chickSize;
    static int homeSize;
    static int [] tmp;
    static int answer;
    static int INF;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        INF = 987654321;
        answer = INF;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1) home.add(new int[]{i,j});
                if(num==2) chicken.add(new int[]{i,j});
            }
        }
        chickSize = chicken.size();
        homeSize = home.size();
        tmp = new int[M];
        comb(0,0);
        System.out.println(answer);

    }
    static void calc(){
        int total = 0;
        for(int [] h : home){
            int minValue = INF;
            int hi = h[0]; int hj = h[1];
            for(int i=0;i<M;i++){
                int[]c = chicken.get(tmp[i]);
                int ci = c[0]; int cj = c[1];
                minValue = Math.min(minValue,(Math.abs(hi - ci)+Math.abs(hj - cj)));
            }
            total += minValue;
            if(answer<=total) return;
        }
        answer = total;
    }
    static void comb(int start,int depth){
        if(depth==M){
            calc();
            return;
        }
        for(int i=start;i<chickSize;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
