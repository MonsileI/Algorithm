package 전체문제.Eleventh_2024_01_02;

import java.util.Arrays;

public class pr_삼각달팽이_Level_2 {

    static int[][] move = {{1,0},{0,1},{-1,-1}};
    static  int[] solution(int n) {
        if(n==1) return new int[]{1};
        int[]dp = new int[n+1];
        dp[1] = 1;
        int plus = 2;
        for(int i=2;i<n+1;i++) {
            dp[i] = dp[i-1]+plus;
            plus++;
        }
        int goal = dp[n];
        int[][]map = new int[n][n];
        int num = 0;
        int dir = 0;
        int i = 0; int j = 0;
        map[i][j] = ++num;
        while(true){
            int ni = i+move[dir][0]; int nj = j + move[dir][1];
            if(n-1<ni||n-1<nj){
                dir = (dir+1)%3;
                if(n-1<ni) ni = n-1;
                if(n-1<nj) nj = n-1;
            }
            else if(map[ni][nj]!=0) {
                ni = i;
                nj = j;
                dir = (dir+1)%3;
            }
            else  map[ni][nj] = ++num;
            if(num==goal) break;
            i = ni; j = nj;

        }
        int[]answer= new int[goal];
        int idx = 0;
        for(int y=0;y<n;y++){
            for(int x=0;x<n;x++){
                if(map[y][x]==0) break;
                answer[idx++] = map[y][x];
            }
        }

        return answer;
    }
    public static void main(String[] args) {

        /*
        TEST CASE
        int n = 4; result = {1,2,9,3,10,8,4,5,6,7};
        int n = 5; result = {1,2,12,3,13,11,4,14,15,10,5,6,7,8,9};
        int n = 6; result = {1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11};
        * */
        int n = 4;
        System.out.println(Arrays.toString(solution(5)));
    }
}
