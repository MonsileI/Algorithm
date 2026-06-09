package 전체문제2026.June.Fifth;

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

    public static void main(String[] args) {
        int[][]land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height = 3;
        System.out.println(solution(land,height));
    }
    static int N,M,H;
    static int[][]map;
    static boolean[][]visited;
    static int[][]nodeMap;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int nodeN;
    static int [] parent;
    static  int solution(int[][] land, int height) {
        H = height;
        N = land.length;
        M = land[0].length;
        map = new int[N][M];
        nodeMap = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = land[i][j];
            }
        }
        nodeN = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    nodeMap[i][j] = nodeN;
                    bfs(i,j);
                    nodeN++;
                }
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(rangeCheck(ni,nj) == false) continue;
                    if(nodeMap[i][j]!=nodeMap[ni][nj]){
                        int cur = nodeMap[i][j];
                        int next = nodeMap[ni][nj];
                        int diff = Math.abs(map[i][j]-map[ni][nj]);
                        pq.offer(new Node(cur,next,diff));
                    }
                }
            }
        }
        int cnt = 0;
        int answer = 0;
        parent =new int[nodeN];
        for(int i=1;i<nodeN;i++) parent[i] = i;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int rootA = find(cur.from);
            int rootB = find(cur.to);
            if(rootA!=rootB){
                union(cur.from,cur.to);
                cnt++;
                answer += cur.weight;
            }
            if(cnt==nodeN-1) break;
        }

        return answer;
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parent[rootB]= rootA;
        else parent[rootA]= rootB;
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(rangeCheck(ni,nj) == false) continue;
                if(visited[ni][nj]) continue;
                if(H<Math.abs(map[i][j]-map[ni][nj])) continue;
                visited[ni][nj] = true;
                nodeMap[ni][nj] = nodeN;
                q.offer(new int[]{ni,nj});
            }
        }
    }
    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
}
