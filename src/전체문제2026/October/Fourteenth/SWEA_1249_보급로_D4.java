package 전체문제2026.October.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_1249_보급로_D4 {
    static class Node implements Comparable<Node>{
        int i; int j ; int cnt;

        public Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int[][]move = {{-1 ,0},{0,1},{1,0},{0,-1}};
        for(int t=1;t<=TC;t++){
            int answer = INF;
            int N = Integer.parseInt(br.readLine());
            int[][]dist = new int[N][N];
            int[][]map = new int[N][N];
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = str.charAt(j) - '0';
                    dist[i][j] = INF;
                }
            }
            PriorityQueue<Node> pq= new PriorityQueue<>();
            pq.offer(new Node(0,0,map[0][0]));
            dist[0][0] = map[0][0];
            while(!pq.isEmpty()){
                Node c = pq .poll();
                int i = c.i; int j =c.j; int cnt = c.cnt;
                if(i==N-1 && j==N-1){
                    answer = Math.min(answer,cnt);
                    break;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(dist[ni][nj] > map[ni][nj] + cnt){
                        dist[ni][nj] = map[ni][nj] + cnt;
                        pq.offer(new Node(ni,nj,map[ni][nj]+cnt));
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
