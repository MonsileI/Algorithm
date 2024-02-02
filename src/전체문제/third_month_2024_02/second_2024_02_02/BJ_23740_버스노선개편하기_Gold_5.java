package 전체문제.third_month_2024_02.second_2024_02_02;
import java.util.*;
import java.io.*;
public class BJ_23740_버스노선개편하기_Gold_5 {
    static class Node implements Comparable<Node>{
        int start ; int end; int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return start - o.start;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Node node = new Node(s,e,w);
            arr[i] = node;
        }
        Arrays.sort(arr);
        int start = arr[0].start;
        int end = arr[0].end;
        int min = arr[0].weight;
        int cnt = 0;
        for(int i=1;i<N;i++){
            if(arr[i].start>end){
                cnt++;
                sb.append(start+" "+end+" "+min+"\n");
                start = arr[i].start;
                end = arr[i].end;
                min = arr[i].weight;
            }else{
                min = Math.min(min,arr[i].weight);
                end = Math.max(end,arr[i].end);
            }
        }
        cnt++;
        sb.append(start+" "+end+" "+min);
        sb.insert(0,cnt+"\n");
        System.out.println(sb.toString());
    }
}
