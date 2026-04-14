package 전체문제2026.April.Eighth;

import java.util.Arrays;

public class PR_삼각달팽이_Level_2 {


    public static void main(String[] args) {
        int n = 6;
        System.out.println(Arrays.toString(solution(n)));
    }


    static int[] solution(int n) {

        int[][]move = {{1,0},{0,1},{-1,-1}};
        int[][]map = new int[n][n];
        int cnt = 1;
        int dir = 0;
        int plus = 1;
        int i = 0; int j  =0;
        int[]dp = new int[n+1];
        for(int num=1;num<n+1;num++) dp[num] = dp[num-1] + plus++;
        int maxNum = dp[n];
        while(true){
            if(maxNum<cnt) break;
            map[i][j] = cnt++;
            int ni = i + move[dir][0];
            int nj = j + move[dir][1];
            if(ni<0||nj<0||n-1<ni||n-1<nj) {
                dir = (dir+1)%3;
                ni = i + move[dir][0];
                nj = j + move[dir][1];
            }else if(map[ni][nj]!=0) {
                dir = (dir+1)%3;
                ni = i + move[dir][0];
                nj = j + move[dir][1];
            }
            i = ni; j = nj;
        }
        int[]answer = new int[maxNum];
        int idx = 0;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(map[i][j]==0) break;
                answer[idx++] = map[i][j];
            }
        }
        return answer;
    }
}
