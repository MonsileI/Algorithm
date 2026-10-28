package 전체문제2026.October.Sixteenth;

import java.util.*;

public class PR_베스트앨범_Level_3 {
    static class Node implements Comparable<Node>{
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt == o.cnt ? idx - o.idx : -(cnt-o.cnt);
        }
    }
    static class Genre implements Comparable<Genre>{
        String str;
        int sum;

        public Genre(String str, int sum) {
            this.str = str;
            this.sum = sum;
        }

        @Override
        public int compareTo(Genre o) {
            return -(sum - o.sum);
        }
    }
    public static void main(String[] args) {
        String [] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[]plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres,plays)));
    }
    static  int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> groupByMap = new HashMap<>();
        Map<String,List<Node>> list = new HashMap<>();
        int N = genres.length;
        for(int i=0;i<N;i++){
            String g = genres[i];
            int cnt = plays[i];
            if(!groupByMap.containsKey(g)){
                groupByMap.put(g,0);
                list.put(g,new ArrayList<>());
            }
            groupByMap.put(g,groupByMap.getOrDefault(g,0) + cnt);
            list.get(g).add(new Node(i,cnt));
        }
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(String key : groupByMap.keySet()){
            Collections.sort(list.get(key));
            pq.offer(new Genre(key,groupByMap.get(key)));
        }
        List<Integer> answerList = new ArrayList<>();
        while(!pq.isEmpty()){
            Genre cur = pq.poll();
            answerList.add(list.get(cur.str).get(0).idx);
            if(list.get(cur.str).size()==1) continue;
            answerList.add(list.get(cur.str).get(1).idx);
        }
        int[]answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++) answer[i] = answerList.get(i);
        return answer;
    }
}
