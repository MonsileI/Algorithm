package 전체문제2026.July.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_4008_숫자만들기 {
    static int N;
    static char[]opArr = {'+','-','*','/'};
    static int[]num;
    static int[]opNum;
    static int min,max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            opNum = new int[4];
            num = new int[N];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<4;i++){
                opNum[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            dfs(1,num[0]);
            sb.append("#"+t+" "+(max-min)+"\n");
        }
        System.out.println(sb.toString());

    }
    static void dfs(int depth,int value) {
        if(depth==N){
            max = Math.max(max,value);
            min = Math.min(min,value);
            return;
        }
        for(int i=0;i<4;i++) {
           if(opNum[i]==0) continue;
            char op = opArr[i];
            int newOne = calc(op,value,num[depth]);
            opNum[i]--;
            dfs(depth+1,newOne);
            opNum[i]++;
        }
    }
    static int calc(char op, int num,int next) {
        switch (op) {
            case '+': num += next; break;
            case '-': num -= next; break;
            case '*': num *= next; break;
            case '/': num /= next; break;
        }
        return num;
    }
}



