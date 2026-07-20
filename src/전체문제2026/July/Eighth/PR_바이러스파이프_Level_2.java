package 전체문제2026.July.Eighth;

import java.util.*;

public class PR_바이러스파이프_Level_2 {

    public static void main(String[] args) {
        int n = 10;
        int infection = 1;
        int[][]edges = {{1, 2, 1}, {1, 3, 1}, {1, 4, 3}, {1, 5, 2}, {5, 6, 1}, {5, 7, 1}, {2, 8, 3}, {2, 9, 2}, {9, 10, 1}};
        int k = 2;
        System.out.println(solution(n,infection,edges,k));
    }
    static Map<Integer,List<int[]>> map;
    static int pN; //파이프 개수
    static int K;
    static int N; // 노드 개수
    static int[]tmp;
    static int answer;
    static int Infection;
    static List<List<List<Integer>>> list;
    static int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
            for(int j=0;j<=3;j++) {
                list.get(i).add(new ArrayList<>());
            }
        }
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int type = edges[i][2];
            if(!map.containsKey(type)){
                map.put(type, new ArrayList<>());
            }
            map.get(type).add(new int[]{from,to});
            list.get(from).get(type).add(to);
            list.get(to).get(type).add(from);
            pN = Math.max(pN,type);
        }
        Infection = infection;
        K = k;
        N = n;
        tmp = new int[K];
        dfs(0);
        return answer;
    }
    static void calc(){
        boolean[]isPolution = new boolean[N+1];
        isPolution[Infection] = true;
        Queue<Integer> q = null;
        for(int pipe : tmp){
            if(!map.containsKey(pipe)) continue;
            q = new ArrayDeque<>();
            boolean[]visited= new boolean[N+1];
            for(int [] node : map.get(pipe)){
                int a = node[0]; int b= node[1];
                if(isPolution[a]) {
                    visited[a] = true;
                    q.offer(a);
                }
                if(isPolution[b]) {
                    visited[b] = true;
                    q.offer(b);
                }
            }
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : list.get(cur).get(pipe)){
                    if(visited[next]) continue;
                    if(!isPolution[next]){
                        isPolution[next] = true;
                    }
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        int sum = 0;
        for(int i=1;i<=N;i++){
            if(isPolution[i]) sum++;
        }

        answer = Math.max(answer,sum);
    };
    static void dfs(int depth){
        if(depth==K){
            calc();
            return;
        }
        for(int i=1;i<=pN;i++){

            tmp[depth] = i;
            dfs(depth+1);
        }

    }
}

