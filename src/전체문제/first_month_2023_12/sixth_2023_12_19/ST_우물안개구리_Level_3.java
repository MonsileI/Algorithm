package 전체문제.first_month_2023_12.sixth_2023_12_19;
import java.util.*;
import java.io.*;
public class ST_우물안개구리_Level_3 {
    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return -(weight - o.weight);
        }
    }
    static int[]powers;
    static List<PriorityQueue<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        powers = new int[N+1];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)powers[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N+1;i++) list.add(new PriorityQueue<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list.get(a).offer(new Node(b,powers[b]));
            list.get(b).offer(new Node(a,powers[a]));
        }
        int ans = 0;
        for(int i=1;i<N+1;i++){
            if(list.get(i).isEmpty()) ans++;
            else if(powers[i]>list.get(i).peek().weight)ans++;
        }
        System.out.println(ans);
    }
}
