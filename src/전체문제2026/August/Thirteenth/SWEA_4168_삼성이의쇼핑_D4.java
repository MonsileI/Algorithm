package 전체문제2026.August.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_4168_삼성이의쇼핑_D4 {
    static int N;
    static int budget;
    static int[][]arr;
    static int maxLike;
    static int answerBit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb =new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            budget = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][2];
            maxLike = 0; answerBit = 0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            comb(0,0,0,0,0);
            sb.append("#"+t+" ");
            for(int i=0;i<N;i++){
                if((answerBit & (1 << i)) != 0){
                    sb.append(i+" ");
                }
            }
            sb.append(maxLike+"\n");
        }
        System.out.println(sb.toString());
    }
    static void comb(int start, int depth, int bit,int sum,int like){
        if(maxLike < like){
            maxLike = like;
            answerBit = bit;
        }
        if(depth==N){
            return;
        }

        for(int i=start;i<N;i++){
            if(sum+arr[i][0] < budget){
                comb(i+1,depth+1,(bit | 1 << i),sum+arr[i][0],like + arr[i][1]);
            }

        }
    }
}
