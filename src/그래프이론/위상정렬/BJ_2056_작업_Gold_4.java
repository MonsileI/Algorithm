package 그래프이론.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2056_작업_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //작업 시간
        int[]dist = new int[N+1];
        int[]time = new int[N+1];
        int ans = 0;
        StringTokenizer st = null;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        Queue<Integer> q= new ArrayDeque<>();
        int[]result = new int[N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            time[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            dist[i] = num;
            result[i] = time[i];
            if(num==0) q.offer(i);
            for(int j=0;j<num;j++){
                list.get(Integer.parseInt(st.nextToken())).add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : list.get(node)){
                dist[next]--;
                result[next] = Math.max(result[next],result[node]+time[next]);
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }
        for(int i=1;i<N+1;i++) ans = Math.max(ans,result[i]);
        System.out.println(ans);
    }
}
