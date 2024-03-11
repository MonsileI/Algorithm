package 전체문제.fourth_month_2024_03.eighth_2024_03_11;
import java.util.*;
import java.io.*;
public class BJ_28018_시간이겹칠까_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[1000001];
        StringTokenizer st= null;
        int max = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s]++;
            if(e<1000000){
                arr[e+1]--;
            }
            max = Math.max(max,e);
        }
        int sum  = 0;
        for(int i=0;i<1000001;i++){
            sum += arr[i];
            arr[i] = sum;
        }
        StringBuilder sb= new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(arr[num]+"\n");
        }
        System.out.println(sb.toString());
    }
}
