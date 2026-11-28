package 전체문제2026.November.Ninteenth;

import java.util.*;
import java.io.*;
public class BJ_17220_마약수사대_Gold_4 {
    static int[]alphaDist;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        alphaDist = new int[N];
        list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int from = st.nextToken().charAt(0) -'A';
            int to = st.nextToken().charAt(0) - 'A';
            list.get(from).add(to);
            alphaDist[to]++;
        }
        st = new StringTokenizer(br.readLine()," ");
        int cnt = Integer.parseInt(st.nextToken());
        for(int i=0;i<cnt;i++){
            int node = st.nextToken().charAt(0) - 'A';
            alphaDist[node] = 0;
            dfs(node);
        }
        int answer = 0;
        for(int i=0;i<N;i++) if(0<alphaDist[i]) answer++;
        System.out.println(answer);
    }
    static void dfs(int node){
        if(alphaDist[node]==0){
            for(int next : list.get(node)){
                alphaDist[next]--;
                dfs(next);
            }
        }
    }
}
