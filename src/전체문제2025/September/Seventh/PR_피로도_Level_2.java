package 전체문제2025.September.Seventh;

public class PR_피로도_Level_2 {

    static int answer;
    static boolean[]visited;
    static int N;
    public static void main(String[] args) {
        int k = 80; //현재 피로도
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};  //최소 피로도, 소모 피로도
        System.out.println(solution(k, dungeons));
    }

    static int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited=  new boolean[N];
        dfs(k,0,dungeons);
        return answer;
    }

    static void dfs(int k,int depth, int [][]dungeons){
        answer = Math.max(answer,depth);
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            if(dungeons[i][0] <= k && dungeons[i][1] < k){
                visited[i] = true;
                dfs(k-dungeons[i][1],depth+1,dungeons);
                visited[i] = false;
            }

        }
    }
}
