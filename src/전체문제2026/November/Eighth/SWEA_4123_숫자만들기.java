package 전체문제2026.November.Eighth;
import java.util.*;
import java.io.*;
public class SWEA_4123_숫자만들기 {
    static int N;
    static int[]op;
    static char[]opArr = {'+','-','*','/'};
    static int[]num;
    static int M = 4;
    static int max,min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            op = new int[M];
            max = -1000000001;
            min = 1000000001;
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++) op[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) num[i] = Integer.parseInt(st.nextToken());
            perm(1,num[0]);
            sb.append("#"+t+" "+(max - min)+"\n");
        }
        System.out.println(sb.toString());
    }
    static void perm(int depth, int sum){
        if(depth==N){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }

        for(int i=0;i<M;i++){
            if(0<op[i]) {
                op[i]--;
                int newSum = calc(sum, num[depth], opArr[i]);
                perm(depth + 1, newSum);
                op[i]++;
            }
        }
    }

    static int calc(int a,int b,char ch){
        switch (ch){
            case'+':return a + b;
            case'-':return a - b;
            case'*':return a * b;
            case'/':return a / b;
        }
        return -1;
    }
}
