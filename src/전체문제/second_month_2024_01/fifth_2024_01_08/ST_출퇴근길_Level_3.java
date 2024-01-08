package 전체문제.second_month_2024_01.fifth_2024_01_08;
import java.util.*;
import java.io.*;
public class ST_출퇴근길_Level_3 {
    static List<List<Integer>> list;
    static int N;
    static boolean[]visited;
    static int answer;
    static boolean[]secVisited;
    static int start, end;
    static boolean [] check;
    static boolean [] fircheck;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
        }
        st =new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        secVisited = new boolean[N+1];
        check = new boolean[N+1];
        fircheck = new boolean[N+1];

        dfs(start);
        secVisited[end] = true;
        secDfs(end);
        System.out.println(answer);

    }
    static void secDfs(int node){
        if(node==start) return;
        for(int next : list.get(node)){
            if(!secVisited[next]){
                secVisited[next] = true;
                if(fircheck[next]) {
                    if(!check[next]&&next!=start){
                        check[next] = true;
                        answer++;
                    }
                }
                secDfs(next);
                secVisited[next] = false;
            }
        }
    }
    static void dfs(int node){
        if(node==end) return;
        for(int next : list.get(node)) {
            if(!visited[next]) {
                visited[next] = true;
                if(!fircheck[next]) fircheck[next] = true;
                dfs(next);
                visited[next] = false;
            }
        }
    }
}
