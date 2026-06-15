package 전체문제2026.June.Seventh;

import java.util.*;
import java.io.*;
public class SWEA_2112_보호필름 {
    static int N,M,K;
    static int[][]map;
    static boolean flag;
    static int G;
    static int[]tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            flag = false;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int d=0;d<N;d++){
                G = d;
                tmp = new int[N];
                comb(0,0);
                if(flag) {
                    answer = d;
                    break;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }

    static void calc(){
        int[][]tmpMap = new int[N][M];
        for(int i=0;i<N;i++){
            if(tmp[i]!=0) {
                int node = tmp[i];
                Arrays.fill(tmpMap[i],node);
            }else{
                for (int j = 0; j < M; j++) {
                    tmpMap[i][j] = map[i][j];
                }
            }
        }

        for(int j=0;j<M;j++){
            boolean oneFlag = false;
            boolean zeroFlag = false;
            int one = 0;
            int zero = 0;
            boolean isPass = false;
            for(int i=0;i<N;i++){
                if(tmpMap[i][j]==1){
                    if(oneFlag){
                        one++;
                    }else{
                        oneFlag = true;
                        zeroFlag = false;
                        one = 1;
                        zero = 0;
                    }
                }else{
                    if(zeroFlag){
                        zero++;
                    }else{
                        oneFlag = false;
                        zeroFlag = true;
                        one = 0;
                        zero = 1;
                    }
                }
                if(K<=one || K<=zero){
                    isPass = true;
                    break;
                }
            }
            if(!isPass){
                return;
            }
        }
        flag = true;
    }
    static void comb(int start,int depth){
        if(flag) return;
        if(depth==G){
            calc();
            return;
        }


        for(int i=start;i<N;i++){
            tmp[i] = -1;
            comb(i+1,depth+1);
            tmp[i] = 1;
            comb(i+1,depth+1);
            tmp[i] = 0;
        }
    }
}