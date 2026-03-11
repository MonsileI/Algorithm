package 전체문제2026.March.Fifth;

import java.util.*;
import java.io.*;
public class BJ_17839_BabaisRabbit_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,List<String>> map = new HashMap<>();
        Queue<String> q= new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String tmp[] = br.readLine().split(" is ");
            if(tmp[0].equals("Baba")) q.offer(tmp[0]);
            if(!map.containsKey(tmp[0])) map.put(tmp[0],new ArrayList<>());
            map.get(tmp[0]).add(tmp[1]);
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if(!q.isEmpty()) {
            while (!q.isEmpty()) {
                String str = q.poll();
                if (!map.containsKey(str)) continue;
                for(String word : map.get(str)) {
                    if(!set.contains(word)) {
                        set.add(word);
                        list.add(word);
                        q.offer(word);
                    }
                }
            }
            Collections.sort(list);
            for (String str : list) sb.append(str + "\n");
            System.out.println(sb.toString());
        }
    }
}
