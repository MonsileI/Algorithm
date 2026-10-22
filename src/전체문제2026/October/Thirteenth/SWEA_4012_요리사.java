package 전체문제2026.October.Thirteenth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
    static int N;
    static int[][]arr;
    static boolean[]tmp;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            arr = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            tmp = new boolean[N];
            comb(0,0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void calc(){
        int a = 0;
        int b = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(tmp[i] && tmp[j]) a += arr[i][j];
                if(!tmp[i] && !tmp[j]) b += arr[i][j];
            }
        }

        answer = Math.min(answer,Math.abs(a-b));
    }
    static void comb(int depth,int start){
        if(depth==N/2){
            calc();
            return;
        }
        for(int i=start;i<N;i++){
            tmp[i] = true;
            comb(depth+1,i+1);
            tmp[i] = false;
        }
    }
}
