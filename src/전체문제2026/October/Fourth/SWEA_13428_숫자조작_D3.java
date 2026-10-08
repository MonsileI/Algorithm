package 전체문제2026.October.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_13428_숫자조작_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            char[]arr = br.readLine().toCharArray();
            int N = arr.length;
            // rule 1. 0으로 시작하면 안됨
            // 최솟값 -> 0으로 시작 안하면서 가장 앞에서 가져올만한 num
            // 최댓값 -> 0으로 시작 안하면서 가장 뒤에서 가져올만한 num
            String minValue = "";
            //최솟값
            OuterLoop:
            for(int i=0;i<N;i++){
                int num = arr[i] - '0';
                int min = 10;
                int idx = -1;
                for(int j=i+1;j<N;j++){
                    int tmp = arr[j] - '0';
                    if(tmp<=min){
                        if(i==0 && tmp==0) continue;
                        min = tmp;
                        idx = j;
                    }
                }
                if(idx != -1 && min < num){
                    for(int j=0;j<N;j++){
                        if(j==idx) minValue += arr[i];
                        else if(j==i) minValue += arr[idx];
                        else minValue += arr[j];
                    }
                    break;
                }
                if(i == N-1){
                    minValue = new String(arr);
                }
            }
            //최댓값
            String maxValue = "";
            for(int i=0;i<N;i++){
                int num = arr[i] - '0';
                int max = num;
                int idx = i;
                for(int j=N-1;i<j;j--){
                    int tmp = arr[j] - '0';
                    if(max<tmp){
                        max = tmp;
                        idx = j;
                    }
                }
                if(idx!=i || i == N-1){
                    for(int j=0;j<N;j++){
                        if(j==idx) maxValue += arr[i];
                        else if(j==i) maxValue += arr[idx];
                        else maxValue += arr[j];
                    }
                    break;
                }
            }
            sb.append("#"+t+" "+minValue+" "+maxValue+"\n");
        }
        System.out.println(sb.toString());
    }
}