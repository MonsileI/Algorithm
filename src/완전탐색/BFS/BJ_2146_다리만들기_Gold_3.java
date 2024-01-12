package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_다리만들기_Gold_3 {

    static class Node implements Comparable<Node>{
        int i;int j; int cnt;

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
    static int[][]map;
    static int[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer = 987654321;
    static int size;
    static int []tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 1;
        visited=  new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1&&visited[i][j]==0){
                    bfs(i,j,idx);
                    idx++;
                }
            }
        }
        boolean []check = new boolean[idx];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]!=0&&!check[visited[i][j]]){
                    check[visited[i][j]] = true;
                    answer = Math.min(answer,calc(i,j,visited[i][j]));
                }
            }
        }

        System.out.println(answer);
    }
    static int calc(int y,int x,int num){
        PriorityQueue<Node> pq= new PriorityQueue<>();
        pq.offer(new Node(y,x,0));
        boolean[][] sVisited = new boolean[N][N];
        sVisited[y][x] = true;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i; int j = now.j; int cnt = now.cnt;
            if(cnt>answer) return 987654321;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!sVisited[ni][nj]){
                    sVisited[ni][nj] = true;
                    if(map[ni][nj]==0) pq.offer(new Node(ni,nj,cnt+1));
                    else {
                        if(visited[ni][nj]!=num) {
                            return cnt;
                        }
                        pq.offer(new Node(ni,nj,cnt));
                    }
                }
            }
        }
        return 987654321;
    }

    static void bfs(int y,int x,int num){
        visited[y][x] = num;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(visited[ni][nj]==0&&map[ni][nj]==1){
                    visited[ni][nj] = num;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
