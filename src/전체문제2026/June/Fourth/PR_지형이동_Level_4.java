package 전체문제2026.June.Fourth;

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

    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    static int N,M;
    static int[][]map;
    static int H;
    static int[][]boundaryMap;
    static int[]parent;
    static int num;
    static  int solution(int[][] land, int height) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        H = height;
        map = new int[N][M];
        boundaryMap = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = land[i][j];
            }
        }
        //bfs로 범위 나누기 + 경계선에서의 최솟값 구하기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    boundaryMap[i][j] = num;
                    bfs(i,j,num++);
                }
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int thisNum = boundaryMap[i][j];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    int otherNum = boundaryMap[ni][nj];
                    if(thisNum!=otherNum){
                        pq.offer(new Node(thisNum,otherNum,Math.abs(map[i][j]-map[ni][nj])));
                    }
                }
            }
        }
        parent = new int[num];
        for(int i=0;i<num;i++) parent[i] = i;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int a = cur.from; int b= cur.to;
            if(find(a)!=find(b)){
                union(a,b);
                cnt++;
                answer += cur.weight;
            }
            if(cnt==num-1) break;
        }
        return answer;
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
    static void bfs(int y,int x,int num){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                int diff = Math.abs(map[i][j]-map[ni][nj]);
                if(diff<=H){
                    visited[ni][nj] = true;
                    boundaryMap[ni][nj] = num;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
