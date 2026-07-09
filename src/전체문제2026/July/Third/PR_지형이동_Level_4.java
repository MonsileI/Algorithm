package 전체문제2026.July.Third;

import java.util.*;

public class PR_지형이동_Level_4 {

    static class Node implements Comparable<Node>{
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N,M;
    static int H;
    static boolean[][]visited;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]bfsMap;
    static int[]parent;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) {
        int[][]land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height = 3;
        System.out.println(solution(land,height));
    }
    static int solution(int[][] land, int height) {
        int answer = 0;
        map = land;
        H = height;
        N = land.length; M = land[0].length;
        visited = new boolean[N][M];
        bfsMap = new int[N][M];
        int idx = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    bfs(i,j,idx++);
                }
            }
        }
        pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                checkMinNode(i,j);
            }
        }
        parent = new int[idx];

        int cnt = 0;
        int sum = 0;
        for(int i=0;i<idx;i++) parent[i] = i;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(find(cur.from)!=find(cur.to)){
                sum += cur.weight;
                union(cur.from,cur.to);
                cnt++;
            }
            if(cnt==idx-1) break;
        }
        answer = sum;

        return answer;
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parent[rootB]= rootA;
        else parent[rootA] = rootB;
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node]= find(parent[node]);
    }
    static void checkMinNode(int y,int x){
        int curNode = bfsMap[y][x];
        for(int d=0;d<4;d++){
            int ni = y + move[d][0];
            int nj = x + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(curNode != bfsMap[ni][nj]){
                pq.offer(new Node(curNode,bfsMap[ni][nj],Math.abs(map[y][x]-map[ni][nj])));
            }
        }
    }
    static void bfs(int y,int x,int node){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            bfsMap[i][j] = node;
            for(int d=0;d<4;d++){
                int ni = i  + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(H < Math.abs(map[i][j]-map[ni][nj])) continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
        }
    }
}
