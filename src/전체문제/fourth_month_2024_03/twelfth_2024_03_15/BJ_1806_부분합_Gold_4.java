package 전체문제.fourth_month_2024_03.twelfth_2024_03_15;
import java.util.*;
import java.io.*;
public class BJ_1806_부분합_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[]arr = new long[N];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int L = 0; int R = 0;
        int answer = N;
        boolean flag = false;
        long sum = arr[L];
        if(sum>=M) System.out.println(1);
        else{
            while(R<N){
                if(sum<M) {
                    if(R==N-1) break;
                    sum += arr[++R];
                }
                else{
                    answer = Math.min(answer,R-L+1);
                    sum -= arr[L++];
                    flag=  true;
                }
            }
        System.out.println(flag ? answer : 0);
        }
    }
}
