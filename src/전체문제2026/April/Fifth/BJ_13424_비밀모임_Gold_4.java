package 전체문제2026.April.Fifth;

import java.util.*;
import java.io.*;
public class BJ_13424_비밀모임_Gold_4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][]pw = new int[N+1][N+1];
            int INF = 987654321;
            for(int i=1;i<N+1;i++) Arrays.fill(pw[i],INF);
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pw[a][b] = pw[b][a] = w;
            }
            for(int l=1;l<N+1;l++){
                for(int i=1;i<N+1;i++){
                    for(int j=1;j<N+1;j++){
                        if(i==j) {
                            pw[i][j] = 0;
                            continue;
                        }
                        pw[i][j] = Math.min(pw[i][j],pw[i][l]+pw[l][j]);
                    }
                }
            }
            int f= Integer.parseInt(br.readLine());
            int[]fArr= new int[f];
            int min = INF;
            int answer = -1;
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<f;i++)fArr[i] = Integer.parseInt(st.nextToken());
            for(int i=1;i<N+1;i++){
                int sum = 0;
                boolean flag = true;
                for(int j=0;j<f;j++){
                    int range = pw[fArr[j]][i];
                    if(range==INF){
                        flag = false;
                        break;
                    }
                    sum += pw[fArr[j]][i];
                    if(min<=sum) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    min = sum;
                    answer = i;
                }
            }
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
