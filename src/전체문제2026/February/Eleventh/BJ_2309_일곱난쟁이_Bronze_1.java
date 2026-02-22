package 전체문제2026.February.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_2309_일곱난쟁이_Bronze_1 {
    static int N;
    static int[]arr;
    static int total;
    static boolean flag;
    static int[]tmp;
    static boolean[]answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        arr = new int[N];
        answer = new boolean[N];
        for(int i=0;i<N;i++) total += arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        tmp = new int[2];
        comb(0,0,0);
        StringBuilder sb=  new StringBuilder();
        for(int i =0;i<N;i++){
            if(answer[i]) continue;
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb.toString());
    }
    static void comb(int start,int depth,int sum){
        if(flag) return;
        if(depth==2){
            if(total-sum==100){
                flag = true;
                for(int i=0;i<2;i++){
                    answer[tmp[i]] = true;
                }
            }
            return;
        }
        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(i+1,depth+1,sum+arr[i]);
        }
    }

}
