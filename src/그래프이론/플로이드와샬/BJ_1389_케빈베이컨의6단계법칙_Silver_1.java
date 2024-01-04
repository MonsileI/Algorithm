package 그래프이론.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1389_케빈베이컨의6단계법칙_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][]fw = new int[N+1][N+1];
        int INF = 987654321;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                fw[i][j] = INF;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            fw[a][b] = 1;
            fw[b][a] = 1;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    fw[i][j] = Math.min(fw[i][j],fw[i][l]+fw[l][j]);
                }
            }
        }
        int min = INF;
        int ans = 0;
        OuterLoop:
        for(int i=1;i<N+1;i++){
            int sum = 0;
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                sum += fw[i][j];
                if(min<=sum) continue OuterLoop;
            }
            min = sum;
            ans = i;
        }
        System.out.println(ans);
    }
}
