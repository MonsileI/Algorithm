package 전체문제2026.August.Eighteenth;

import java.util.*;
import java.io.*;
public class GR_증식하는수들1_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            int node = Integer.parseInt(st.nextToken());
            int range = ((node*2) +1) - node;
            int turn  = 0;
            while(node <= K){
                if(!map.containsKey(node)){
                    map.put(node,turn);
                }else{
                    int min = Math.min(map.get(node),turn);
                    map.put(node,min);
                }
                turn++;
                node += range;
                range *= 2;
            }
        }
        int answer = map.getOrDefault(K,-1);

        System.out.println(answer);
    }
}
