package 전체문제2026.November.First;

public class PR_서버증설횟수_Level_2 {
    public static void main(String[] args) {
        int[]players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        System.out.println(solution(players,m,k));
    }
    static int solution(int[] players, int m, int k) {
        int answer = 0;
        //k시간까지 유지됨 m 이상이면 서버가 더 필요함
        int N = players.length;
        int[]server = new int[N];
        for(int i=0;i<N;i++){
            int p = players[i];
            if(p<m) continue;
            int needServer = p/m;
            if(server[i] <needServer){
                int tmp = needServer - server[i];
                answer += tmp;
                for(int j=i;j<i+k;j++){
                    if(N-1<j) break;
                    server[j] += tmp;
                }
            }
        }
        return answer;
    }
}
