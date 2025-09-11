package 전체문제2025.August.Second;

import java.util.*;
import java.io.*;
public class BJ_2303_숫자게임_Silver_5 {
    static int answer = -1;
    static int max = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[5];
            for(int j=0;j<5;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            comb(arr,0,0,0,i);
        }
        System.out.println(answer);
    }
    static void comb(int[]arr,int depth,int total,int cnt,int turn){
        if(cnt==3){
            total %= 10;
            if(max <= total){
                max = total;
                answer = turn+1;
            }
            return;
        }

        for(int i=depth;i<5;i++){
            comb(arr,i+1,total + arr[i],cnt+1,turn);
        }
    }
}
