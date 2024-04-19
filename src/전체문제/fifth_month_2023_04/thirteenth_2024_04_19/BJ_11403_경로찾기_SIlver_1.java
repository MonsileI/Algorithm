package 전체문제.fifth_month_2023_04.thirteenth_2024_04_19;

import java.util.*;
import java.io.*;
public class BJ_11403_경로찾기_SIlver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        int[][]map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int l=0;l<N;l++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==1) continue;
                    if(map[i][l]==1 && map[l][j] ==1 )map[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j==N-1) {
                    sb.append(map[i][j]+"\n");
                    break;
                }
                sb.append(map[i][j]+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
