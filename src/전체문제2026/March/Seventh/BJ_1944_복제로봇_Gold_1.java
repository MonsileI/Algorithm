package 전체문제2026.March.Seventh;

import java.util.*;
import java.io.*;
public class BJ_1944_복제로봇_Gold_1 {
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
    static int N;
    static int K;
    static char[][]map;
    static boolean[][]nodeVisited;
    static int[][]dist;
    static List<int[]> list;
    static int[][]numberMap;
    static int[][]move ={{-1,0},{0,1},{1,0},{0,-1}};
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        numberMap = new int[N][N];
        list = new ArrayList<>();
        int idx = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S') {
                    list.add(new int[]{i,j});
                    map[i][j] = 'K';
                    numberMap[i][j] = idx++;
                }else if(map[i][j]=='K'){
                    list.add(new int[]{i,j});
                    numberMap[i][j] = idx++;
                }
            }
        }
        int len = list.size();
        dist = new int[len][len];
        nodeVisited = new boolean[len][len];
        parent = new int[len];
        for(int i=0;i<len;i++)parent[i] = i;
        for(int i=0;i<len;i++) Arrays.fill(dist[i],987654321);
        boolean flag = true;
        for(int i=0;i<len;i++){
            nodeVisited[i][i] = true;
            boolean tmpFlag = bfs(list.get(i)[0],list.get(i)[1],i);
            if(i==0 && !tmpFlag) {
                flag = false;
                break;
            }
        }
        if(!flag) System.out.println(-1);
        else{
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    if(dist[i][j]!=987654321){
                        pq.offer(new Node(i,j,dist[i][j]));
                    }
                }
            }
            int cnt = 0;
            int sum  =0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int from = cur.from; int to = cur.to; int weight = cur.weight;
                if(find(from) != find(to)){
                    union(from,to);
                    sum += weight;
                    cnt++;
                }
                if(cnt==len-1) break;
            }
            System.out.println(sum);

        }
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    static int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    static boolean bfs(int y,int x,int nodeNum){
        boolean[][]visited = new boolean[N][N];
        visited[y][x] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x,0});
        int returnCnt = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i =c[0];int j = c[1]; int cnt = c[2];
            if(map[i][j]=='K' && !nodeVisited[nodeNum][numberMap[i][j]]){
                nodeVisited[nodeNum][numberMap[i][j]] = nodeVisited[numberMap[i][j]][nodeNum] = true;
                dist[nodeNum][numberMap[i][j]] = dist[numberMap[i][j]][nodeNum] = cnt;
                returnCnt++;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(map[ni][nj]=='1') continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj,cnt+1});
            }
        }
        if(returnCnt!=K) return false;
        return true;
    }
}