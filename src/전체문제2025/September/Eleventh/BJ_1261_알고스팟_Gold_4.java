package 전체문제2025.September.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1261_알고스팟_Gold_4 {

    static class Node implements Comparable<Node>{
        int i; int j; int cnt;

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

    static int N,M;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        map  =new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        int answer = dijk();
        System.out.println(answer);
    }
    static int dijk(){
        int[][]dist = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int i = cur.i; int j = cur.j; int cnt = cur.cnt;
            if(i==N-1 && j==M-1){
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='1'){
                    if(dist[ni][nj] > cnt+1){
                        dist[ni][nj] =cnt+1;
                        pq.offer(new Node(ni,nj,cnt+1));
                    }
                }else{
                    if(dist[ni][nj] > cnt){
                        dist[ni][nj] = cnt;
                        pq.offer(new Node(ni,nj,cnt));
                    }
                }

            }
        }

        return dist[N-1][M-1];
    }
}
