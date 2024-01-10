package 전체문제.second_month_2024_01.seventh_2024_01_10;

import java.util.*;
import java.io.*;
public class BJ_1261_알고스팟_Gold_4 {
    static class Node implements Comparable<Node>{
        int i;int j;int weight;

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
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        boolean[][]visited= new boolean[N][M];
        int answer = 0;
        int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i;int j = now.j; int weight=now.weight;
            if(visited[i][j]) continue;
            visited[i][j] = true;
            if(i==N-1&&j==M-1){
                answer = weight;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i +move[d][0]; int nj= j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='1') pq.offer(new Node(ni,nj,weight+1));
                else pq.offer(new Node(ni,nj,weight));
            }
        }
        System.out.println(answer);
    }
}
