package 전체문제2025.September.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_15686_치킨배달_Gold_5 {
    static List<int[]> chicken;
    static List<int[]> house;
    static int M;
    static int chickenLen;
    static int houseLen;
    static int[]tmp;
    static int answer; //치킨 거리에 최솟값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int node = Integer.parseInt(st.nextToken());
                if(node==1){
                    house.add(new int[]{i,j});
                }
                if(node==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        chickenLen = chicken.size();
        houseLen = house.size();
        tmp = new int[M];
        comb(0,0);
        System.out.println(answer);
    }
    static void comb(int depth, int start){
        if(depth==M){
            int allChickenRange  = 0; //치킨

            for(int[] h : house){
                int chickenRange = Integer.MAX_VALUE;
                for(int i=0;i<M;i++){
                    int[]tmpChicken = chicken.get(tmp[i]);
                    int cur = Math.abs(h[0] - tmpChicken[0]) + Math.abs(h[1] - tmpChicken[1]);
                    chickenRange = Math.min(chickenRange,cur);
                }
                allChickenRange += chickenRange;
            }
            answer = Math.min(answer,allChickenRange);
            return;
        }


        for(int i=start;i<chickenLen;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }


    }
}
