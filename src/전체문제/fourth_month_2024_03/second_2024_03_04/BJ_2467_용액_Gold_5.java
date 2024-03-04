package 전체문제.fourth_month_2024_03.second_2024_03_04;
import java.util.*;
import java.io.*;
public class BJ_2467_용액_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]answer = new int[2];
        int min = Integer.MAX_VALUE;
        int L = 0; int R = N-1;
        while(L<R){
            int sum = arr[L]+arr[R];
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                answer[0] = arr[L];
                answer[1] = arr[R];
            }
            if(sum<0){
                L++;
            }else{
                R--;
            }
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
