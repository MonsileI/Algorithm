package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1800_인터넷설치_Gold_1 {

    static class Node {
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }


    }
    static int N,K;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, w));
            list.get(b).add(new Node(a, w));
        }
        int L = 0;
        int R = 1000000;
        boolean flag = false;
        while (L < R) {
            int mid = (L + R) / 2;
            if (check(mid)){
                R = mid;
                flag = true;
            }
            else L = mid + 1;
        }
        System.out.println(flag ? L : -1);
    }
    static boolean check(int mid){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[N+1][K+1];
        q.offer(new int[]{1,K});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int node = now[0]; int cnt = now[1];
            if(node==N) return true;
            if(visited[node][cnt]) continue;
            visited[node][cnt] = true;
            for(Node next : list.get(node)){
                if(next.weight <= mid)q.offer(new int[]{next.to,cnt});
                else if(cnt>0) q.offer(new int[]{next.to,cnt-1});
            }
        }
        return false;
    }
}
