package 전체문제2025.November.Tenth;

import java.util.*;
import java.io.*;
public class BJ_2258_정육점_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[][] arr = new Integer[N][2];
        int total = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken()); //무게
            arr[i][1] = Integer.parseInt(st.nextToken()); //가격
            total += arr[i][0];
        }
        if(total < M){
            System.out.println(-1);
            return;
        }
        Arrays.sort(arr, (o1, o2) -> {
            int p = o1[1] - o2[1];
            if (p != 0) return p;
            return o2[0] - o1[0];
        });
        int beforePrice = 0;
        int min = Integer.MAX_VALUE;
        int priceSum = 0;
        int weight = 0;
        for(int i=0;i<N;i++){
            weight += arr[i][0];

            if(beforePrice != arr[i][1]){
                beforePrice = arr[i][1];
                priceSum = arr[i][1];
            }else{
                priceSum += arr[i][1];
            }
            if(M<=weight){
                min = Math.min(min,priceSum);
            }

        }
        System.out.println(min);
    }
}
