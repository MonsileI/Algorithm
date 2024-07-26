package 전체문제.eigth_month_2024_07.twelfth_2024_07_23;

import java.util.*;
import java.io.*;
public class BJ_17505_링고와순열_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        //N 길이이면서 M개만 나오려면,
        long max = 0;
        for(int i=1;i<N;i++) max += i;
        if(M>max) System.out.println(-1);
        else{
            //숫자만큼 옮겨주면 됨
            int range = N-1;
            int[]arr = new int[N];
            int cnt = 0;
            while(true){
                if(M-range<=0){
                    if(M-range==0) {
                        range = 0;
                        cnt++;
                        break;
                    }
                    range = N - (int)M -1;

                    break;
                }
                cnt++;
                M -= range;
                range--;
            }
            int idx = 0;
            int value = N;
            while(cnt!=0){
                cnt--;
                arr[idx] = value;
                idx++; value--;
            }
            value = 1;
            for(int i=idx;i<N;i++) arr[i] = value++;
            if(range!=0){
                int tmp = arr[range];
                for(int i=range;i<N-1;i++){
                  arr[i] = arr[i+1];
                }
                arr[N-1] = tmp;
            }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++) sb.append(arr[i]+" ");
        System.out.println(sb.toString());
        }
    }
}
