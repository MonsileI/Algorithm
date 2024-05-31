package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class BJ_31925_APC2shake_Silver_5 {

    static class Node implements Comparable<Node>{
        String name;
        int score;

        public Node(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return score-o.score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i=0;i<N;i++){
            String [] tmp = br.readLine().split(" ");
            if(tmp[1].equals("hewhak") || tmp[2].equals("winner")) continue;
            int shake = Integer.parseInt(tmp[3]);
            if(shake!=-1 && shake<4) continue;
            int score = Integer.parseInt(tmp[4]);
            pq.offer(new Node(tmp[0],score));
        }
        int cnt = 0;
        StringBuilder sb=  new StringBuilder();
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().name);
            cnt++;
            if(cnt==10) break;
        }
        Collections.sort(list);
        for(int i=0;i<cnt;i++) sb.append(list.get(i)+"\n");
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
