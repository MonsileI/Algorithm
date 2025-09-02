package 전체문제2025.August.First;

import java.util.*;
import java.io.*;
public class BJ_ABCDE_Gold_5 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    static boolean isAnswer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            visited[i] = true;
            dfs(i,0);
            visited[i] = false;
            if(isAnswer) {
                break;
            }
        }

        int answer = isAnswer ? 1 : 0;
        System.out.println(answer);

    }
    static void dfs(int node, int depth){
        if(isAnswer){
            return;
        }
        if(4 <= depth){
            isAnswer = true;
            return;
        }

        for(int nextNode : list.get(node)){
            if(!visited[nextNode]){
                visited[nextNode] = true;
                dfs(nextNode,depth+1);
                visited[nextNode] = false;
            }
        }



    }
}
