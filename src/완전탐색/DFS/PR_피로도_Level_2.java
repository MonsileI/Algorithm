package 완전탐색.DFS;

public class PR_피로도_Level_2 {
    static int [][]D;
    static int answer;
    static boolean[]visited;
    static int N;
    static boolean flag;
    static int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        D = dungeons;
        visited=  new boolean[N];
        dfs(k,0);
        return answer;
    }
    static void dfs(int k,int depth){
        if(flag) return;
        if(depth==N){
            answer = N;
            flag = true;
            return;
        }
        answer = Math.max(answer,depth);
        for(int i=0;i<N;i++){
            if(!visited[i] && k >=D[i][0]){
                visited[i] = true;
                dfs(k-D[i][1],depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {

        int k = 80;
        int [][] dungeons = {{80,20},{50,40},{30,10}};
        //return = 3;
        System.out.println(solution(k,dungeons));
    }
}
