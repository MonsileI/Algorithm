package 전체문제2026.April.Third;

import java.util.*;
import java.io.*;
public class BJ_13911_집구하기_Gold_2 {
    static class Node implements Comparable<Node>{
        int to; long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static int N;
    static List<List<Node>> list;
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isMac = new boolean[N+1];
        boolean[] isStar = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        st = new StringTokenizer(br.readLine()," ");
        int mLen = Integer.parseInt(st.nextToken());
        int mMax = Integer.parseInt(st.nextToken());
        int[]mArr = new int[mLen];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<mLen;i++){
            mArr[i] = Integer.parseInt(st.nextToken());
            isMac[mArr[i]] = true;
        }
        st = new StringTokenizer(br.readLine()," ");
        int sLen = Integer.parseInt(st.nextToken());
        int sMax = Integer.parseInt(st.nextToken());
        int[]sArr =new int[sLen];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<sLen;i++){
            sArr[i] = Integer.parseInt(st.nextToken());
            isStar[sArr[i]] = true;
        }
        long[]mDist = disjk(mArr,mLen,mMax);
        long[]sDist = disjk(sArr,sLen,sMax);

        long answer = Long.MAX_VALUE;


        for(int i=1;i<N+1;i++){
            if(isMac[i] || isStar[i]) continue;
            if(mDist[i]==INF || sDist[i] ==INF) continue;
            if(mMax< mDist[i] || sMax < sDist[i]) continue;
            answer = Math.min(answer,(mDist[i]+sDist[i]));
        }
        System.out.println(answer);

    }
    static long[]disjk(int[]arr,int len,int max){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[]dist = new long[N+1];
        Arrays.fill(dist,INF);
        for(int i=0;i<len;i++) {
            pq.offer(new Node(arr[i],0));
            dist[arr[i]] = 0;
        }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.weight > dist[cur.to]) continue;
            if(max < cur.weight) continue;
            for(Node next : list.get(cur.to)){
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
