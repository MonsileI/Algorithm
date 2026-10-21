package 전체문제2026.October.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_2001_파리퇴치_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][]map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int i=0;i<=N-M;i++){
                for(int j=0;j<=N-M;j++){
                    int sum = 0;
                    for(int ii=i;ii<i+M;ii++){
                        for(int jj=j;jj<j+M;jj++){
                            sum += map[ii][jj];
                        }
                    }
                    answer = Math.max(answer,sum);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}