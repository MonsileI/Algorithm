package 전체문제.sixth_month_2023_05.second_2024_05_02;

import java.util.*;
import java.io.*;
public class BJ_14718_용감한용사진수_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][3];
        int min = 3000000;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a; arr[i][1] =b; arr[i][2] = c;
        }
        int[]ans = new int[3];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int l=0;l<N;l++){
                    int cnt = 0;
                    for(int k=0;k<N;k++){
                        if(arr[i][0]>=arr[k][0] && arr[j][1] >= arr[k][1] && arr[l][2] >= arr[k][2]){
                            cnt++;
                        }
                    }
                    if(K<=cnt) min = Math.min(min,arr[i][0]+arr[j][1]+arr[l][2]);
                }
            }
        }
        System.out.println(min);


    }
}
