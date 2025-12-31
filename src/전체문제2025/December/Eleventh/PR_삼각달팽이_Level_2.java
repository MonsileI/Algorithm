package 전체문제2025.December.Eleventh;

import java.util.*;

public class PR_삼각달팽이_Level_2 {
    public static void main(String[] args) {
        int n =  5;
        System.out.println(Arrays.toString(solution(n)));
    }
    static int[] solution(int n) {
        int [][]move = {{1,0},{0,1},{-1,-1}};
        int[][]map = new int[n][n];
        int cnt = 1;
        int d = 0;
        int i = -1;
        int j = 0;
        int end = 1;
        int plus = 2;
        for(int c=1;c<n;c++){
            end += plus;
            plus++;
        }
        end++;
        while(true){

            // i , j 값 반영
            i += move[d][0];
            j += move[d][1];
            // d 조정
            if(i<0||j<0||n-1<i||n-1<j){
                switch (d){
                    case 0 :
                        i--;
                        break;
                    case 1 :
                        j--;
                        break;
                    case 2 :
                        i++;j++;
                        break;
                }
                d = (d+1) % 3;
                continue;
            }
            if(map[i][j]!=0){
                switch (d){
                    case 0 :
                        i--;
                        break;
                    case 1 :
                        j--;
                        break;
                    case 2 :
                        i++;j++;
                        break;
                }
                d = (d+1) % 3;
                continue;
            }
            // i, j 색칠하기
            map[i][j] = cnt++;
            // break 조건
            if(cnt==end) break;

        }
        int[]answer = new int[end-1];
        int idx = 0;
        for(int y=0;y<n;y++){
            for(int x=0;x<n;x++){
                if(map[y][x]==0) break;
                answer[idx++] = map[y][x];
            }
        }
        return answer;
    }
}
