package 그래프이론.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_21940_가운데에서만나기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = 1987654321;
        int[][]map = new int[N+1][N+1];
        for(int i=1;i<N+1;i++) Arrays.fill(map[i],INF);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[from][to] = weight;
        }
        int K = Integer.parseInt(br.readLine());
        int[]arr = new int[K];
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<K;i++)arr[i] = Integer.parseInt(st.nextToken());
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) map[i][j] = 0;
                    if(map[i][l]!=INF && map[l][j]!=INF){
                        map[i][j] = Math.min(map[i][j],map[i][l]+map[l][j]);
                    }
                }
            }
        }
        int min = INF;
        int[]dist = new int[N+1];
        for(int i=1;i<N+1;i++){
            int sum = 0;
            boolean flag = true;
            for(int j=0;j<K;j++){
                if(map[arr[j]][i]==INF || map[i][arr[j]]==INF){
                    flag = false;
                    break;
                }
                sum = Math.max(sum,map[i][arr[j]]+map[arr[j]][i]);

            }
            if(!flag) dist[i] = INF;
            else {
                dist[i] = sum;
                if(sum<min) min = sum;
            }
        }
        StringBuilder sb=  new StringBuilder();
        for(int i=1;i<N+1;i++) if(dist[i]==min) sb.append(i+" ");
        System.out.println(sb.toString());

    }
}
