package 전체문제.fourth_month_2024_03.sixth_2024_03_08;

import java.util.*;

public class PR_섬연결하기_Level_3 {

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
    static int[]parents;
    static int N;
    static int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<costs.length;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int w = costs[i][2];
            pq.offer(new Node(a,b,w));
        }
        N = n;
        parents = new int[N];
        for(int i=0;i<N;i++)parents[i] = i;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                union(now.from,now.to);
                answer += now.weight;
                cnt++;
            }
            if(cnt==N-1) break;
        }
        return answer;
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        int n = 4;
        int[][]costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int return = 4;
        * */
        int n = 4;
        int[][]costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n,costs));
    }
}
