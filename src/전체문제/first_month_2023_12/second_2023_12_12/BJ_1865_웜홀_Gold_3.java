package 전체문제.first_month_2023_12.second_2023_12_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1865_웜홀_Gold_3 {

    static class Node {
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }
    static List<List<Node>> list;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,w));
                list.get(b).add(new Node(a,w));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,-w));
            }

            sb.append(belman() ? "YES" : "NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean belman(){
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                for(Node next : list.get(j)){
                    if(dist[next.to] > dist[j]+next.weight){
                        dist[next.to]= dist[j]+next.weight;
                    }
                }
            }
        }
        for(int i=1;i<N+1;i++){
            for(Node next : list.get(i)){
                if(dist[next.to]> dist[i]+next.weight){
                    return true;
                }
            }
        }
        return false;
    }
}
