package 전체문제2026.June.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_5643_키순서_D4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            boolean[][]check = new boolean[N+1][N+1];
            boolean[][]reverseCheck = new boolean[N+1][N+1];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                check[a][b] = true;
                reverseCheck[b][a] = true;
            }
            for(int l=1;l<N+1;l++){
                for(int i=1;i<N+1;i++){
                    for(int j=1;j<N+1;j++){
                        if(i==j) continue;
                        if(!check[i][j]){
                            if(check[i][l]&&check[l][j]) check[i][j] = true;
                        }
                        if(!reverseCheck[i][j]){
                            if(reverseCheck[i][l]&&reverseCheck[l][j]) reverseCheck[i][j] = true;
                        }
                    }
                }
            }
            int answer = 0;

            for(int i=1;i<N+1;i++){
                boolean flag = true;
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(!check[i][j] && !reverseCheck[i][j]) {
                        flag= false;
                        break;
                    }
                }
                if(flag) answer++;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
