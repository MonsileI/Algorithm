package 전체문제.first_month_2023_12.sixth_2023_12_19;
import java.util.*;
import java.io.*;
public class BJ_15591_MooTube_Gold_5 {

    static class Node {
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int N;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int k = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int ans = bfs(num,k);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());

    }
    static int bfs(int num,int k ){
        int tmp = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[]visited = new boolean[N+1];
        visited[num] = true;
        q.offer(num);
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node next : list.get(now)){
                if(!visited[next.to] && next.weight >= k){
                    visited[next.to] = true;
                    tmp++;
                    q.offer(next.to);
                }
            }
        }

        return tmp;
    }
}
