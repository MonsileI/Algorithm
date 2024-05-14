package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BJ_5635_생일_Silver_5 {
    static class Node implements Comparable<Node>{
        String name;int year; int month; int day;

        public Node(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo( Node o) {
            return year == o.year ? month == o.month ? -(day - o.day) : -(month - o.month) : -(year - o.year);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Node[]arr = new Node[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            arr[i] = new Node(name,year,month,day);
        }
        Arrays.sort(arr);
        System.out.println(arr[0].name);
        System.out.println(arr[N-1].name);
    }
}
