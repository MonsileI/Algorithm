package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10800_컬러볼_Gold_2 {
    static class Node implements Comparable<Node>{
        int idx; int size; int color;

        public Node(int idx, int size, int color) {
            this.idx = idx;
            this.size = size;
            this.color = color;
        }

        @Override
        public int compareTo(Node o) {
            return size - o.size;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[]arr = new Node[N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            arr[i] = new Node(i,size,color);
        }
        Arrays.sort(arr);
        int[]colors = new int[N+1];
        int[]result = new int[N];
        int sum = 0; int idx = 0;
        for(int i=0;i<N;i++){
            Node now = arr[i];
            while(arr[idx].size < now.size){
                sum += arr[idx].size;
                colors[arr[idx].color] += arr[idx].size;
                idx++;
            }
            result[now.idx] = (sum - colors[now.color]);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++) sb.append(result[i]+"\n");
        System.out.println(sb.toString());
    }
}
