package 전체문제2026.March.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_1460_진욱이의농장_Gold_3 {
    static int answer;
    static List<Integer> fList;
    static int[]tmp;
    static int size;
    static int N;
    static int[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int t=0;t<M;t++){
            st = new StringTokenizer(br.readLine()," ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int shape = Integer.parseInt(st.nextToken());
            for(int i=y;i<y+width;i++){
                for(int j=x;j<x+width;j++){
                    map[i][j] = shape;
                }
            }
        }
        fList = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!fList.contains(map[i][j])) fList.add(map[i][j]);
            }
        }
        size = fList.size();
        tmp = new int[2];
        comb(0,0);
        answer = (int)Math.pow(answer,2);
        System.out.println(answer);
    }
    static void calc(){
        int fir = tmp[0]; int sec = tmp[1];
        int[][]dp = new int[N][N];
        int result = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0) continue;
                if(map[i][j]==fir || map[i][j]==sec){
                    if(i==0||j==0) {
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        answer = Math.max(answer,result);
    }
    static void comb(int depth, int start){
        if(depth==2 || depth==size){
            calc();
            return;
        }

        for(int i=start;i<size;i++){
            tmp[depth] = fList.get(i);
            comb(depth+1,i+1);
        }
    }

}
