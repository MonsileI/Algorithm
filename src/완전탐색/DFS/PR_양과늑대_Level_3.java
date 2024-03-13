package 완전탐색.DFS;

public class PR_양과늑대_Level_3 {
    static int[]I;
    static int[][]E;
    static int answer;
    static int N;
    static boolean[]visited;
    static int solution(int[] info, int[][] edges) {
        E = edges;
        I = info;
        N = info.length;
        visited= new boolean[N];
        visited[0] = true;
        dfs(0,0,0);
        return answer;
    }
    static void dfs(int s,int w,int node){
        if(I[node]==0) s++;
        else{
            w++;
            if(s<=w) return;
        }
        answer = Math.max(answer,s);
        for(int [] next : E){
            if(visited[next[0]] && !visited[next[1]]){
                visited[next[1]] = true;
                dfs(s,w,next[1]);
                visited[next[1]] = false;
            }
        }
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[]info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][]edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        int return = 5;

        2.
        int[]info = {0,1,0,1,1,0,1,0,0,1,0};
        int[][]edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};

        int return = 5;
        * */
        int[]info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][]edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution(info,edges));
    }
}
