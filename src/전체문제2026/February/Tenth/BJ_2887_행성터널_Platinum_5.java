package 전체문제2026.February.Tenth;

import java.util.*;
import java.io.*;
public class BJ_2887_행성터널_Platinum_5 {
    static class Node implements Comparable<Node>{
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight -o.weight;
        }
    }
    static int N;
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i=1;i<N;i++) parent[i] = i;
        StringTokenizer st = null;
        int[][]arr = new int[N][4];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr,(o1,o2) -> o1[1] - o2[1]);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N-1;i++){
            int diff =Math.abs(arr[i][1] - arr[i+1][1]);
            pq.offer(new Node(arr[i][0],arr[i+1][0],diff));
        }
        Arrays.sort(arr,(o1,o2) -> o1[2] - o2[2]);
        for(int i=0;i<N-1;i++){
            int diff =Math.abs(arr[i][2] - arr[i+1][2]);
            pq.offer(new Node(arr[i][0],arr[i+1][0],diff));
        }
        Arrays.sort(arr,(o1,o2) -> o1[3] - o2[3]);
        for(int i=0;i<N-1;i++){
            int diff =Math.abs(arr[i][3] - arr[i+1][3]);
            pq.offer(new Node(arr[i][0],arr[i+1][0],diff));
        }

        int cnt = 0;
        int sum = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int a = node.from;
            int b= node.to;
            int w = node.weight;
            if(find(a)!=find(b)){
                union(a,b);
                cnt++;
                sum += w;
            }
            if(cnt==N-1) break;
        }
        System.out.println(sum);


    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}
