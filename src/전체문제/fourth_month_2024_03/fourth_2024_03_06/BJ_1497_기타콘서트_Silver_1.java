package 전체문제.fourth_month_2024_03.fourth_2024_03_06;
import java.util.*;
import java.io.*;
public class BJ_1497_기타콘서트_Silver_1 {
    static int [][] arr;
    static int N,M;
    static boolean[]tmp;
    static int max; static int maxCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            st.nextToken();
            String str = st.nextToken();
            for(int j=0;j<M;j++){
                if(str.charAt(j)=='Y') arr[i][j] = 1;
            }
        }
        tmp = new boolean[N];
        comb(0,0);
            if(max==0) System.out.println(-1);
            else System.out.println(maxCnt);
    }
    static void comb(int depth,int sum){
        if(depth==N){
            boolean[]check = new boolean[M];
            for(int i=0;i<N;i++){
                if(!tmp[i]) continue;
                for(int j=0;j<M;j++){
                    if(arr[i][j]==1) check[j] = true;
                }
            }
            int total = 0;
            boolean flag = true;
            for(int i=0;i<M;i++){
                if(check[i]) total++;
                if(!check[i]) flag = false;
            }
            if(total==max) maxCnt = Math.min(maxCnt,sum);
            if(max<total){
                max = total;
                maxCnt = sum;
            }
            return;
        }

        tmp[depth] = true;
        comb(depth+1,sum+1);
        tmp[depth] = false;
        comb(depth+1,sum);
    }
}
