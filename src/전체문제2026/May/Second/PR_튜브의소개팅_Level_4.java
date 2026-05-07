package 전체문제2026.May.Second;

import java.util.*;

public class PR_튜브의소개팅_Level_4 {
    static class Node implements Comparable<Node>{
        int i; int j; int cnt;long weight;

        public Node(int i, int j,int cnt, long weight) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return cnt == o.cnt ? Long.compare(weight,o.weight) : cnt - o.cnt;
        }
    }
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int s= 25;
        int[][]time_map = {{0, 1, 1, -1, 2, 4}, {-1, 7, 2, 1, 5, 7}, {-1, 1, -1, 1, 6, 3}, {-1, 1, -1, -1, 7, 0}};
        System.out.println(Arrays.toString(solution(m,n,s,time_map)));
    }
    static int[] solution(int m, int n, int s, int[][] time_map) {
        int N = m;
        int M = n;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[][]dp = new long[N][M];
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) Arrays.fill(dp[i],INF);
        dp[0][0] = 0;
        pq.offer(new Node(0,0,0,0));
        long minRange = Long.MAX_VALUE;
        long minTime = Long.MAX_VALUE;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int i = cur.i; int j = cur.j; int cnt = cur.cnt; long weight = cur.weight;
            if(minRange < cnt) continue;
            if(minRange == cnt && minTime < weight) continue;
            if(i==N-1&&j==M-1){
                minRange = cur.cnt;
                minTime = cur.weight;
                continue;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(time_map[ni][nj]==-1) continue;
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(s<weight+time_map[ni][nj]) continue;
                if(dp[ni][nj] < weight+time_map[ni][nj]) continue;
                dp[ni][nj] = weight+time_map[ni][nj];
                pq.offer(new Node(ni,nj,cnt+1,weight+time_map[ni][nj]));
            }
        }
        return new int[]{(int)minRange,(int)minTime};

    }
}
