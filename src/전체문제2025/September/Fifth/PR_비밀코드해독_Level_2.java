package 전체문제2025.September.Fifth;

import java.util.Arrays;

public class PR_비밀코드해독_Level_2 {

    static int N;
    static int[]ANS;
    static int[][]Q;
    static int answer;
    static int[]tmp;
    public static void main(String[] args) {

        int n = 10;
        int [][]q = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{3, 7, 8, 9, 10},{2, 5, 7, 9, 10},{3, 4, 5, 6, 7}};
        int []ans = {2, 3, 4, 3, 3};
        tmp = new int[5];
        N = n; Q = q; ANS = ans;
        System.out.println(solution(n,q,ans));
    }
    static int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        comb(0,1);
        return answer;
    }

    static void calc(){

        for(int i=0;i<Q.length;i++){
            int cnt = 0;
            for(int j=0;j<5;j++){
                for(int l=0;l<5;l++) {
                    if (tmp[j] == Q[i][l]) {
                        cnt++;
                        break;
                    }
                }
                if(ANS[i]<cnt) return;
            }
            if(ANS[i]!=cnt) return;
        }
        answer++;
    }

    static void comb(int depth,int start){
        if(depth==5){
            calc();
            return;
        }
        for(int i=start;i<N+1;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }

    }
}
