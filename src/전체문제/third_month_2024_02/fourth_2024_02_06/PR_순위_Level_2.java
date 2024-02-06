package 전체문제.third_month_2024_02.fourth_2024_02_06;

public class PR_순위_Level_2 {

    static int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][]win = new boolean[n+1][n+1];
        boolean[][]lose = new boolean[n+1][n+1];
        for(int i=0;i<results.length;i++){
            win[results[i][0]][results[i][1]] = true;
            lose[results[i][1]][results[i][0]] = true;
        }
        for(int l=1;l<n+1;l++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j) continue;
                    if(win[i][l] && win[l][j]) win[i][j] = true;
                    if(lose[i][l] && lose[l][j]) lose[i][j] = true;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            int cnt = 0;
            for(int j=1;j<n+1;j++){
                if(win[i][j])cnt++;
                if(lose[i][j]) cnt++;
            }
            if(cnt==n-1)answer++;
        }
        return answer;
    }
    public static void main(String[] args) {

        /*
        TEST CASE
        int n = 5;
        int [][] results = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}};

        int result = 2;
        * */
        int n = 5;
        int [][] results = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}};
        System.out.println(solution(n,results));
    }
}
