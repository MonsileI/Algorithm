package 전체문제.third_month_2024_02.third_2024_02_05;
import java.util.*;
import java.io.*;
public class BJ_16938_캠프준비_Gold_5 {
    static int N,L,R,X;
    static int[]arr;
    static int answer;
    static boolean[]tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tmp = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        comb(0,0);
        System.out.println(answer);

    }
    static void comb(int depth,int cnt){

        if(depth==N){
            if(cnt>=2){
                int sum  =0;
                int min = 987654321;
                int max = 0;
                for(int i=0;i<N;i++){
                    if(!tmp[i]) continue;
                    min = Math.min(min,arr[i]);
                    max = Math.max(max,arr[i]);
                    sum += arr[i];
                }
                if(sum>=L&&sum<=R&&(max-min)>=X) answer++;
            }
            return;
        }


        tmp[depth] = true;
        comb(depth+1,cnt+1);
        tmp[depth] = false;
        comb(depth+1,cnt);
    }
}
