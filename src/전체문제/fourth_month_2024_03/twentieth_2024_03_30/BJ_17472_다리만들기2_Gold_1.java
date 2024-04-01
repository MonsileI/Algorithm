package 전체문제.fourth_month_2024_03.twentieth_2024_03_30;

import java.util.*;
import java.io.*;
public class BJ_17472_다리만들기2_Gold_1 {

    static class Node implements Comparable<Node>{
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight ==o.weight ? from - o.from : weight - o.weight;
        }
    }
    static int N,M;
    static int [][]map;
    static List<List<int[]>> list;
    static int idx;
    static boolean[][]visited;
    static int [][]move ={{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]check;
    static int nodeCnt;
    static int [] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list = new ArrayList<>();
        list.add(new ArrayList<>());
        idx = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]==1){
                    visited[i][j] = true;
                    list.add(new ArrayList<>());
                    list.get(idx).add(new int[]{i,j});
                    map[i][j] = idx;
                    bfs(i,j);
                    idx++;
                }
             }
        }
        nodeCnt = list.size();
        check = new int[nodeCnt][nodeCnt];
        for(int i=1;i<nodeCnt;i++) Arrays.fill(check[i],987654321);
        for(int i=1;i<nodeCnt;i++){
            for(int j=1;j<nodeCnt;j++){
                if(i==j) continue;
                if(check[i][j] != 987654321|| check[j][i]!= 987654321) continue;
                visited = new boolean[N][M];
                checkBfs(i);
            }
        }
        parents = new int[nodeCnt];
        for(int i=1;i<nodeCnt;i++)parents[i] = i;
        int cnt = 0;
        int ans = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1;i<nodeCnt;i++){
            for(int j=1;j<nodeCnt;j++){
                if(check[i][j]==987654321) continue;
                pq.offer(new Node(i,j,check[i][j]));
            }
        }
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                ans += now.weight;
                cnt++;
                union(now.from,now.to);
            }
            if(cnt==nodeCnt-2) break;
        }
        System.out.println(cnt==nodeCnt-2 ? ans : -1);
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
    static void checkBfs(int node){
        Queue<int[]> q = new ArrayDeque<>();
        for(int t=0;t<list.get(node).size();t++){
            int y = list.get(node).get(t)[0];
            int x = list.get(node).get(t)[1];
            for(int d=0;d<4;d++) q.offer(new int[]{y, x, 0, d});
            visited[y][x] = true;
        }
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2]; int dir = c[3];
            int ni = i + move[dir][0];
            int nj = j + move[dir][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(!visited[ni][nj] && map[ni][nj]!=node){
                visited[ni][nj] = true;
                if(map[ni][nj]!=0&&map[ni][nj]!=node){
                    if(cnt==1) continue;
                    check[node][map[ni][nj]] = check[map[ni][nj]][node] = Math.min(check[map[ni][nj]][node],Math.min(cnt,check[node][map[ni][nj]]));
                    continue;
                }
                q.offer(new int[]{ni,nj,cnt+1,dir});
            }

        }

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
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!=0){
                    visited[ni][nj] = true;
                    list.get(idx).add(new int[]{ni,nj});
                    map[ni][nj] = idx;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}