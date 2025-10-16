package 전체문제2025.September.Seventh;

public class PR_등굣길_Level_3 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int [][] puddles = {{2,2}};
        //4
        System.out.println(solution(m,n,puddles));

    }
    static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][]map = new int[n][m];
        for(int [] p : puddles){
            map[p[1]-1][p[0]-1] = -1;
        }
        map[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(map[i][j]==-1) continue;
                if(i==0 && j==0) continue;

                int top = (i == 0 || map[i-1][j]==-1) ? 0 : map[i-1][j];
                int left = (j == 0 || map[i][j-1]==-1) ? 0 : map[i][j-1];

                map[i][j] = (top+left) % 1_000_000_007;
            }
        }
        answer = map[n-1][m-1];
        return answer;
    }

}
