package 전체문제2026.July.August.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_4796_의석이의우뚝선산_D4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(sc.nextLine());
        for(int t=1;t<=TC;t++){
            int N = sc.nextInt();
            int[]arr= new int[N+1];
            for(int i=0;i<N;i++)arr[i] = sc.nextInt();
            arr[N] = Integer.MAX_VALUE; //마지막 노드를 위한 값 할당
            //3개의 값에 대해
            //1 4 6 5 3 -> 1465, 14653, 465, 4653
            //1 4 5 6 3 -> 14563 , 4563 , 563
            // 증가하는 수열을 찾으면, 다시 다음 수열은 계속 작을때까지
            int L = 0; int mid = 0;
            for(int i=1;i<=N;i++){
                if(arr[i-1]<arr[i]){
                    L = i-1;
                    break;
                }
            }
            boolean flag = true; //증가하는 수열을 찾을 때 true, 감소하는 수열은 false;
            int answer = 0;
            for(int i=L;i<N;i++){
                if(flag) {
                    if (arr[i+1] < arr[i]) {
                        flag = false;
                        mid = i;
                    }
                }else{
                    if(arr[i]< arr[i+1]){
                        flag = true;
                        answer += (mid-L)*(i-mid);
                        L = i;
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
