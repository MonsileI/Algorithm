package 전체문제2025.December.Fourth;

import java.util.*;
import java.io.*;
public class BJ_1268_임시반장정하기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N+1][5];
        StringTokenizer st = null;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int answer = 1;
        for(int i=1;i<N+1;i++){
            boolean []visited = new boolean[N+1];
            visited[i] = true;
            int cnt = 0;
            for(int j=0;j<5;j++){
                for(int l=1;l<N+1;l++){
                    if(i==l) continue;
                    if(visited[l]) continue;
                    if(arr[i][j] == arr[l][j]){
                        visited[l] = true;
                        cnt++;
                    }
                }
            }
            if(max<cnt){
                max = cnt;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
