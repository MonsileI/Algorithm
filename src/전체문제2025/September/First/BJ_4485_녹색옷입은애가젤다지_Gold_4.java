package 전체문제2025.September.First;

import java.io.*;
import java.util.*;

public class BJ_4485_녹색옷입은애가젤다지_Gold_4 {

    static class Node implements Comparable<Node>{

        int i;
        int j;
        int weight;

        public Node(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String Problem = "Problem ";
        int TC  = 1;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        while(true){

            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int[][]map = new int[N][N];
            int[][]dist = new int[N][N];
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dist[0][0] = map[0][0];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0,0,map[0][0]));
            int answer = Integer.MAX_VALUE;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                int i = node.i;
                int j = node.j;
                int w = node.weight;
                if(i==N-1 && j == N-1){
                    answer = Math.min(answer,w);
                    continue;
                }
                if(answer <= w) continue;
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if( dist[ni][nj] > map[ni][nj] + w ){
                        dist[ni][nj] = map[ni][nj] + w;
                        pq.offer(new Node(ni,nj,dist[ni][nj]));
                    }
                }
            }
            sb.append(Problem+TC+": "+answer+"\n");
            TC++;
        }
        System.out.println(sb.toString());
    }
}
