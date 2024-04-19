package 전체문제.fifth_month_2023_04.second_2024_04_02;


import java.util.*;
import java.io.*;
public class  BJ_4485_녹색옷입은애가젤다지_Gold_4 {

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
    static int N;
    static int [][] map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0,0,map[0][0]));
            boolean[][]visited=  new boolean[N][N];
            visited[0][0] = true;
            int answer = 0;
            while(!pq.isEmpty()){
                Node now = pq.poll();
                int i = now.i; int j = now.j; int cnt = now.cnt;
                if(i==N-1&&j==N-1){
                    answer = cnt;
                    break;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(!visited[ni][nj]){
                        visited[ni][nj] = true;
                        pq.offer(new Node(ni,nj,cnt+map[ni][nj]));
                    }
                }
            }
            sb.append("Problem "+tc+": "+answer+"\n");
            tc++;
        }
        System.out.println(sb.toString());
    }
}
