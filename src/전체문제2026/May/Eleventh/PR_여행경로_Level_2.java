package 전체문제2026.May.Eleventh;

import java.util.*;
public class PR_여행경로_Level_2  {
    static class Node implements Comparable<Node>{
        String city;
        int idx;

        public Node(String city, int idx) {
            this.city = city;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.city.compareTo(o.city);
        }
    }
    static boolean[]visited;
    static int N;
    static Map<String,List<Node>> map;
    static int[]tmp;
    static boolean flag;
    static List<String> list;
    static String[][]TicKet;
    public static void main(String[] args) {
        String[][]tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }
    static String[] solution(String[][] tickets) {
        TicKet = tickets;
        list = new ArrayList<>();
        map = new HashMap<>();
        N = tickets.length;
        visited = new boolean[N];
        tmp = new int[N];
        for(int i=0;i<N;i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(new Node(to,i));
        }
        for(String str : map.keySet()){
            Collections.sort(map.get(str));
        }
        dfs("ICN",0);
        String[]answer = new String[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    static void dfs(String city, int depth){
        if(flag) return;
        if(depth==N){
            flag = true;
            list.add("ICN");
            for(int i=0;i<N;i++){
                list.add(TicKet[tmp[i]][1]);
            }
            return;
        }
        List<Node> nextList = map.get(city);

        if(nextList == null) return;

        for(Node cur : nextList){
            String next = cur.city;
            int idx = cur.idx;
            if(visited[idx]) continue;
            visited[idx] = true;
            tmp[depth] = idx;
            dfs(next,depth+1);
            visited[idx] = false;
        }
    }
}
