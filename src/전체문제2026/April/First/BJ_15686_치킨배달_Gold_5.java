package 전체문제2026.April.First;

import java.util.*;
import java.io.*;
public class BJ_15686_치킨배달_Gold_5 {
    static List<int[]> chicken;
    static List<int[]> house;
    static int M;
    static int[]tmp;
    static int size;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        answer = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int node = Integer.parseInt(st.nextToken());
                if(node==1) house.add(new int[]{i,j});
                if(node==2) chicken.add(new int[]{i,j});
            }
        }
        size = chicken.size();
        tmp = new int[M];
        comb(0,0);
        System.out.println(answer);
    }
    static void comb(int start,int depth){
        if(depth==M){
            int sum  = 0;
            for(int[] h : house){
                int min = Integer.MAX_VALUE;
                for(int i=0;i<M;i++){
                    int ci = chicken.get(tmp[i])[0]; int cj = chicken.get(tmp[i])[1];
                    int diff = Math.abs(ci-h[0]) + Math.abs(cj-h[1]);
                    min = Math.min(min,diff);
                    }
                sum += min;
            }
            answer = Math.min(answer,sum);
            return;
        }
        for(int i=start;i<size;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }



    }
}
