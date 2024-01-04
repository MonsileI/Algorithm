package 전체문제.first_month_2023_12.second_2023_12_12;
import java.util.*;
import java.io.*;
public class BJ_6630_로또_Silver_2 {
    static StringBuilder sb;
    static int[]tmp;
    static int N;
    static int []arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            tmp = new int[6];
            arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            comb(0,0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void comb(int start,int depth){

        if(depth==6){
            for(int i=0;i<6;i++)sb.append(tmp[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            tmp[depth] = arr[i];
            comb(i+1,depth+1);
        }
    }
}
