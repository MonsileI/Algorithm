package 전체문제2026.October.Second;

import java.util.*;
import java.io.*;
public class SWEA_1220_Magnetic_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = 1;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]map = new int[N][N];
            //1은 N극, 2는 S극 (N극은 N쪽으로, S극은 0쪽으로)
            int answer = 0;
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]!=0) answer++;
                }
            }
            for(int j=0;j<N;j++){
                int matS = 0; int matN = 0;
                for(int i=0;i<N;i++){
                    if(map[i][j]==1) {
                        answer -= matS;
                        break;
                    }
                    if(map[i][j]==2) matS++;
                }
                for(int i=N-1;-1<i;i--){
                    if(map[i][j]==2){
                        answer -= matN;
                        break;
                    }
                    if(map[i][j]==1) matN++;
                }

            }
            System.out.println(answer);
        }
        System.out.println(sb.toString());
    }
}
